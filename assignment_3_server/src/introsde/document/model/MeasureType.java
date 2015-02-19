/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introsde.document.model;

import introsde.document.dao.LifeCoachDao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class that maps the entity measuretype on database
 * @author roberto
 */
@Entity
@Table(name = "MeasureType")
@NamedQueries({
    @NamedQuery(name = "MeasureType.findAll", query = "SELECT ms FROM MeasureType ms"),
    @NamedQuery(name = "MeasureType.findMT", query = "SELECT ms FROM MeasureType ms where ms.measurename = :measurename")
})
@XmlRootElement
public class MeasureType implements Serializable {
     
    @Id
    @OneToMany(mappedBy="idmt")
    private int idmt;
    
    @Column(name = "measurename")
    private String measurename;
    
    @Column(name = "measureValueType")
    private String measureValueType;

    public String getMeasureValueType() {
        return measureValueType;
    }

    public void setMeasureValueType(String measureValueType) {
        this.measureValueType = measureValueType;
    }

    @XmlTransient
    public int getIdmt() {
        return idmt;
    }

    public void setIdmt(int idmt) {
        this.idmt = idmt;
    }

    public String getMeasurename() {
        return measurename;
    }

    public void setMeasurename(String measurename) {
        this.measurename = measurename;
    }

    @Override
    public boolean equals(Object obj) {
        MeasureType m = (MeasureType) obj;
        return this.measurename == m.getMeasurename();
    }
    
    /**
     * Returns all list of measuretype on database
     */
    static public List<MeasureType> getAll(){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        List<MeasureType> list = em.createNamedQuery("MeasureType.findAll", MeasureType.class).getResultList();
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }
    
    /**
     * return an entity measuretype from a measurename
     */
    static public MeasureType getMeasureTypeByMt(String mt){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        
        MeasureType me = em.createNamedQuery("MeasureType.findMT", MeasureType.class)
                .setParameter("measurename", mt)
                .getSingleResult();
        LifeCoachDao.instance.closeConnections(em);
        return me;
    }
    
}
