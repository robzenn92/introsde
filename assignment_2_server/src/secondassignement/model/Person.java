package secondassignement.model;

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

import secondassignement.Settings;
import secondassignement.dao.LifeCoachDao;

/**
 * Class that maps the entity person of database
 *
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
    public static PersonBean getPersonBeanById(int personId) {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Person p = em.find(Person.class, personId);
        LifeCoachDao.instance.closeConnections(em);
        PersonBean pb = new PersonBean();
        pb.setBirthdate(p.getBirthdate());
        pb.setFirstname(p.getName());
        pb.setLastname(p.getLastname());
        pb.setHealthprofile(
                HealthProfile.getHealthProfileFromMeasureList(
                        Measure.getAll(personId)));
        pb.setIdp(personId);
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
     * Get all people in database
     */
    public static People getAllPersonBean() {

        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
        ArrayList<PersonBean> listB = new ArrayList<>();
        for (Person p : list) {
        	try {
	            PersonBean pb = new PersonBean();
	            pb.setBirthdate(p.getBirthdate());
	            
	            System.out.println("Person found: " + p.getName() + " " + p.getLastname());
	            
	            pb.setFirstname(p.getName());
	            pb.setLastname(p.getLastname());
	            pb.setIdp(p.getIdPerson());
	            // check if the person has some measure in the db..
	            if(p.getMeasure().size() > 0) {
	            	pb.setHealthprofile(
	            			HealthProfile.getHealthProfileFromMeasureList(
	            					Measure.getAll(p.getIdPerson())));
	            }
	            listB.add(pb);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        People p = new People();
        p.setPerson(listB);
        System.err.println(p);
        LifeCoachDao.instance.closeConnections(em);
        return p;

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
    public static PersonBean savePerson(PersonBean pB) {
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
        pB.setIdp(p.getIdPerson());
        LifeCoachDao.instance.closeConnections(em);
        try {
            HealthProfile hp = pB.getHealthprofile();
            for (MeasureBean mB : hp.getMeasure()) {
                mB.setIdp(p.getIdPerson());
                String now = new Date().getTime() + "";
                mB.setCreated(now);
                Measure m = new Measure();
                m.setIdp(p);
                m.setDate(now);
                m.setValue(mB.getValue());
                m.setIdmt(MeasureType.getMeasureTypeByMt(mB.getMeasureType()));
                Measure.saveMeasure(m);
            }
        } catch (Exception e) {
            System.err.println("Exception");
        }
        return pB;
    }

    /**
     * Update a person mapped by personbean in database
     */
    public static Person updatePerson(PersonBean pb) {
        
        Person p = new Person();
        System.err.println(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
        p.setBirthdate(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
        System.err.println(pb.getIdp());
        p.setIdPerson(pb.getIdp());
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
