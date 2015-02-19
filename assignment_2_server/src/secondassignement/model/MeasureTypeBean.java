/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import secondassignement.dao.LifeCoachDao;

/**
 * @author roberto
 */
@XmlRootElement(name = "MeasureTypes")
public class MeasureTypeBean {
    
    List<String> measureTypes = new ArrayList<>();

    @XmlElement(name = "MeasureType")
    public List<String> getMeasureTypes() {
        return measureTypes;
    }

    public void setMeasureTypes(List<String> measureTypes) {
        this.measureTypes = measureTypes;
    }
    
    public MeasureTypeBean(){
        for(MeasureType m:MeasureType.getAll()){
            measureTypes.add(m.getMeasurename());
        }
    }
    
    /**
     * It connects to the database
     * @return all measureType in database
     */
    static public MeasureTypeBean getAll(){
        EntityManager em = LifeCoachDao.instance.createEntityManager();
        MeasureTypeBean list = new MeasureTypeBean();
        LifeCoachDao.instance.closeConnections(em);
        return list;
    }
}
