

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 * @author roberto
 */
@Entity
@Table(name = "Measure")
@NamedQueries({
    @NamedQuery(name = "Measure.findAll", query = "select m from Measure m"),
    @NamedQuery(name = "Measure.findForPerson", query = "select m from Measure m WHERE m.idp = :idp "),
    @NamedQuery(name = "Measure.findForPersonForType", query = "select m from Measure m where m.idp = :id and m.idmt = :mt"),
    @NamedQuery(name = "Measure.getNameMeasure", query = "select mt.measurename from MeasureType mt,Measure mh WHERE mt.idmt = mh.idmt"),
    @NamedQuery(name = "Measure.findForPersonForTypeByMid", query = "select m from Measure m where m.idp = :id and m.idmt = :mt and m.mid = :mid")
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
    
    public Measure(){ }
    
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
     * get all list of measures
     * @return 
     */
    public static List<Measure> getAll(){
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Measure> list = em.createNamedQuery("Measure.findAll", Measure.class).getResultList();
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }
    
    /**
     * get all list of measures for that person with that id
     * @param idper
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
     * get all measure ( MeasureHistory) of a type for a person
     * @param id personid
     * @param mt measuretype
     * @return measurehistory
     */
    public static MeasureHistory getAllForMeasureType(int id,String mt){
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
     * get all measure ( MeasureHistory) of a type for a person
     * @param id personid
     * @param mt measuretype
     * @return measurehistory
     */
    public static List<introsde.document.beans.Measure> getAllForMeasureBeanType(int id,String mt){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<Measure> list = em.createNamedQuery("Measure.findForPersonForType", Measure.class)
                .setParameter("id", Person.getPersonById(id))
                .setParameter("mt", MeasureType.getMeasureTypeByMt(mt))
                .getResultList();
        MeasureHistory m = new MeasureHistory();
        m.setMeasure(list);
        LifeCoachDao.instance.closeConnections(em);
        List<introsde.document.beans.Measure> mblist = new ArrayList<>();
        for(Measure mm:list){
            introsde.document.beans.Measure newMb = new introsde.document.beans.Measure();
            newMb.setDateRegistered(mm.getDate());
            newMb.setMeasureType(mm.getMeaureName());
            newMb.setMeasureValue(mm.getValue());
            newMb.setMeasureValueType(mm.getIdmt().getMeasureValueType());
            newMb.setMid(mm.getMid());
            mblist.add(newMb);
        }
        return mblist;
        
    }
    
    /**
     * return the measure with that mid
     * @param id personid
     * @param mt measureType
     * @param mid measure Id
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
     * return the measure with that mid
     * @param id personid
     * @param mt measureType
     * @param mid measure Id
     * @return 
     */
    public static introsde.document.beans.Measure getMeasureBeanTypeById(int id,String mt,int mid){
        //System.err.println(id + " " + mt + " " +mid);
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        Measure mm = em.createNamedQuery("Measure.findForPersonForTypeByMid", Measure.class)
                .setParameter("id", Person.getPersonById(id))
                .setParameter("mt", MeasureType.getMeasureTypeByMt(mt))
                .setParameter("mid", mid)
                .getSingleResult();
        LifeCoachDao.instance.closeConnections(em);
        introsde.document.beans.Measure ret = new introsde.document.beans.Measure();
        ret.setDateRegistered(mm.getDate());
        ret.setMeasureType(mm.getMeaureName());
        ret.setMeasureValue(mm.getValue());
        ret.setMeasureValueType(mm.getIdmt().getMeasureValueType());
        ret.setMid(mm.getMid());
        return ret;
    }
    
    /**
     * saves a measure in database
     * @param m measure
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
     * saves a measure mapped by a measureBean mb
     * @param mb Measurebean to get saved
     * @return 
     */
    public static introsde.document.beans.Measure saveMeasure(introsde.document.beans.Measure mb,Long id) {
        
        String now = new Date().getTime() + "";
        Measure m = new Measure();
        m.setIdp(Person.getPersonById(id.intValue()));
        m.setDate(now);
        m.setValue(mb.getMeasureValue());
        m.setIdmt(MeasureType.getMeasureTypeByMt(mb.getMeasureType()));
        
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(m);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        mb.setMid(m.getMid());
        return mb;
    }
    
    public static introsde.document.beans.Measure updateMeasure(introsde.document.beans.Measure mb, Long id) {
        
//        Measure p = new Measure();
//        System.err.println(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
//        p.setBirthdate(Settings.convertFromDateToTimestamp(pb.getBirthdate()));
//        System.err.println(pb.getPersonId());
//        p.setIdPerson((int)pb.getPersonId());
//        p.setLastname(pb.getLastname());
//        p.setName(pb.getFirstname());
//        
//        EntityManager em = LifeCoachDao.instance.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        p = em.merge(p);
//        tx.commit();
//        LifeCoachDao.instance.closeConnections(em);
//        return p;
    	return null;
    }
    
}
