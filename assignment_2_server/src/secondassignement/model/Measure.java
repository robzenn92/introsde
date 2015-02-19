/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import secondassignement.Settings;
import secondassignement.dao.LifeCoachDao;

/**
 * @author roberto
 */
@Entity
@Table(name = "Measure")
@NamedQueries({
    @NamedQuery(name = "Measure.findAll", query = "select m from Measure m"),
    @NamedQuery(name = "Measure.findForPerson", query = "select m from Measure m WHERE m.idp = :idp "),
    @NamedQuery(name = "Measure.findForPersonForType", 
            query = "select m from Measure m where m.idp = :id and m.idmt = :mt"),
    @NamedQuery(name = "Measure.getNameMeasure", 
            query = "select mt.measurename from MeasureType mt,Measure mh WHERE mt.idmt = mh.idmt"),
    @NamedQuery(name = "Measure.findForPersonForTypeByMid", 
            query = "select m from Measure m where m.idp = :id and m.idmt = :mt and m.mid = :mid")
}) 
@XmlRootElement(name = "measure")
public class Measure implements Serializable{
    
    @Id
    @GeneratedValue(generator = "sqlite_measure")
    @TableGenerator(name = "sqlite_measure", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "Measure")
    @Column(name = "mid")
    private int mid;

    @Column(name = "value")
    private double value;
    
    @Column(name = "date")
    private String date;
    
    @ManyToOne
    @JoinColumn(name="idmt",referencedColumnName="idmt")
    private MeasureType idmt;
            
    @ManyToOne
    @JoinColumn(name="idp",referencedColumnName="idp")
    private Person idp;
    
    public Measure(){
        
    }
    
    @XmlElement(name="measureType")
    public String getMeaureName() {
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Measure m = em.find(Measure.class, mid);
        LifeCoachDao.instance.closeConnections(em);
        return m.idmt.getMeasurename();
    }
    
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @XmlTransient
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @XmlElement(name = "created")
    public String getNiceDate() {
        return Settings.convDate(date);
    }

    @XmlTransient
    public MeasureType getIdmt() {
        return idmt;
    }
    
    public void setIdmt(MeasureType idmt) {
        this.idmt = idmt;
    }

    @XmlTransient
    public Person getIdp() {
        return idp;
    }

    public void setIdp(Person idp) {
        this.idp = idp;
    }
    
    /**
     * It returns the list of all measures
     * @return 
     */
    public static List<Measure> getAll(){
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Measure> list = em.createNamedQuery("Measure.findAll", Measure.class).getResultList();
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }
    
    /**
     * It returns a list of measures that corresponds to a person with the given id
     * @param idper the id of a person
     * @return 
     */
    public static List<Measure> getAll(int idper){
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Measure> list;
        list = em.createNamedQuery("Measure.findForPerson", Measure.class)
                .setParameter("idp", Person.getPersonById(idper))
                .getResultList();
        
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }
    
    /**
     * It returns a  MeasureHistory of a type for a person
     * @param id the id of a person
     * @param mt the measure type
     * @return measurehistory
     */
    public static MeasureHistory getAllForMeasureType(int id, String mt){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Measure> list = em.createNamedQuery("Measure.findForPersonForType", Measure.class)
                .setParameter("id", Person.getPersonById(id))
                .setParameter("mt", MeasureType.getMeasureTypeByMt(mt))
                .getResultList();
        MeasureHistory m = new MeasureHistory();
        m.setMeasure(list);
        LifeCoachDao.instance.closeConnections(em);
        return m;
        
    }
    
    /**
     * It returns the measure that corresponds to the given mid
     * @param id the id of a person
     * @param mt the measure type
     * @param mid the id of a measurement
     * @return 
     */
    public static Measure getMeasureTypeById(int id,String mt,int mid){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Measure ret = em.createNamedQuery("Measure.findForPersonForTypeByMid", Measure.class)
                .setParameter("id", Person.getPersonById(id))
                .setParameter("mt", MeasureType.getMeasureTypeByMt(mt))
                .setParameter("mid", mid)
                .getSingleResult();
        LifeCoachDao.instance.closeConnections(em);
        return ret;
        
    }
    
    /**
     * It stores a measurement in the database
     * @param m a measure that will be store in the database
     * @return 
     */
    public static Measure saveMeasure(Measure m) {
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(m);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        
        return m;
        
    }
    
    /**
     * It stores a measurement given a MeasureBean instance
     * @param mb the MeasureBean instance that will be stored
     * @return 
     */
    public static MeasureBean saveMeasure(MeasureBean mb) {
        
        String now = new Date().getTime() + "";
        Measure m = new Measure();
        m.setDate(now);
        m.setValue(mb.getValue());
        m.setIdmt(MeasureType.getMeasureTypeByMt(mb.getMeasureType()));
        m.setIdp(Person.getPersonById(mb.getIdp()));
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(m);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        mb.setMid(m.getMid());
        return mb;
    }
}