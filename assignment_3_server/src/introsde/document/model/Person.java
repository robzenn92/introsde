package introsde.document.model;

import introsde.document.dao.LifeCoachDao;
import introsde.st.Settings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author roberto
 */
@Entity
@Table(name = "person")
@NamedQuery(name = "Person.findAll", query = "select p From Person p")
@XmlRootElement
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "sqlite_person")
    @TableGenerator(name = "sqlite_person", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "Person")
    @Column(name = "idp")
    private int idPerson;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String name;

    @Column(name = "birthdate")
    private String birthdate;

    @OneToMany(mappedBy = "idp")
    private List<Measure> measure;

    @XmlTransient
    public List<Measure> getMeasure() {
        return measure;
    }

    public void setMeasure(List<Measure> measure) {
        this.measure = measure;
    }

    public Person() {
    }

    public int getIdPerson() {
        return this.idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return Settings.convDate(this.birthdate);
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Get person by id and return a PesonBean
     */
    public static introsde.document.beans.Person getPersonBeanById(int personId) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Person p = em.find(Person.class, personId);
        LifeCoachDao.instance.closeConnections(em);
        introsde.document.beans.Person pb = new introsde.document.beans.Person();
        pb.setBirthdate(p.getBirthdate());
        pb.setFirstname(p.getName());
        pb.setLastname(p.getLastname());
        pb.setCurrentHealth(
                HealthProfile.getHelathProfileFromMeasureList(
                        introsde.document.model.Measure.getAll(personId)));
        pb.setPersonId(personId);
        return pb;
    }

    /**
     * Get person by id and return a Person
     */
    public static Person getPersonById(int personId) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Person p = em.find(Person.class, personId);
        LifeCoachDao.instance.closeConnections(em);
        return p;
    }

    /**
     * Gt all peoplein database
     */
    public static ArrayList<introsde.document.beans.Person> getAllPersonBean() {

        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
        ArrayList<introsde.document.beans.Person> listB = new ArrayList<>();
        for (Person p : list) {
            introsde.document.beans.Person pb = new introsde.document.beans.Person();
            pb.setBirthdate(p.getBirthdate());
            pb.setFirstname(p.getName());
            pb.setLastname(p.getLastname());
            pb.setPersonId(p.getIdPerson());
            System.err.println(p.getMeasure());
            pb.setCurrentHealth(
                HealthProfile.getHelathProfileFromMeasureList(
                        introsde.document.model.Measure.getAll(p.getIdPerson())));
            listB.add(pb);
        }
        return listB;

    }

    /**
     * Get all person in database
     */
    public static List<Person> getAll() {

        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
        LifeCoachDao.instance.closeConnections(em);
        return list;

    }

    /**
     * Save a person mapped by personbean in database
     */
    public static introsde.document.beans.Person savePerson(introsde.document.beans.Person pB) {
        Person p = new Person();
        p.setLastname(pB.getLastname());
        p.setName(pB.getFirstname());
        System.err.println(pB.getBirthdate());
        p.setBirthdate(Settings.convertFromDateToTimestamp(pB.getBirthdate()));
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        pB.setPersonId(p.getIdPerson());
        LifeCoachDao.instance.closeConnections(em);
        try {
            List<introsde.document.beans.Measure> hp = pB.getCurrentHealth();
            for (introsde.document.beans.Measure mB : hp) {
                //mB.setIdp(p.getIdPerson());
                String now = new Date().getTime() + "";
                mB.setDateRegistered(now);
                introsde.document.model.Measure m = new introsde.document.model.Measure();
                m.setIdp(p);
                m.setDate(now);
                m.setValue(mB.getMeasureValue());
                m.setIdmt(MeasureType.getMeasureTypeByMt(mB.getMeasureType()));
                introsde.document.model.Measure.saveMeasure(m);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return pB;
    }

    /**
     * Update a person mapped by personbean in database
     */
    public static Person updatePerson(introsde.document.beans.Person pb) {
        
        Person p = new Person();
        System.err.println(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
        p.setBirthdate(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
        System.err.println(pb.getPersonId());
        p.setIdPerson((int)pb.getPersonId());
        p.setLastname(pb.getLastname());
        p.setName(pb.getFirstname());
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p = em.merge(p);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        return p;
    }

    /**
     * Remove a person from database
     */
    public static void removePerson(Person p) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p = em.merge(p);
        em.remove(p);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
    }

}
