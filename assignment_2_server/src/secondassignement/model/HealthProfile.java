/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondassignement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author roberto
 */
@XmlRootElement
public class HealthProfile implements Serializable {

	// Each person has a list of measure
    private List<MeasureBean> measure;

    public HealthProfile() { }

    @XmlElement(name = "measure")
    public List<MeasureBean> getMeasure() {
        return measure;
    }

    public void setMeasure(List<MeasureBean> measure) {
        this.measure = measure;
    }
    
    /**
     * Return an HealthProfile object given a list of measure.
     * For each measure type, the last measurement is found and placed into an HealthProfile instance.
     */
    public static HealthProfile getHealthProfileFromMeasureList(List<Measure> measure) {
        HealthProfile hp = new HealthProfile();
        List<Measure> list_measure = new ArrayList<Measure>();
        
        try {
        	
        	List<MeasureType> list_measureType = MeasureType.getAll();
        	Measure last = null;
        	double current_date;
        	double last_date;
        	
        	for(MeasureType mt : list_measureType) {
        		
        		last = null;
        		
        		for (Measure m : measure) {
        			
        			if(m.getMeaureName() == mt.getMeasurename()) {
        				
        				if(last == null) { last = m; }
        				else {
        					
        					// Get dates
        					last_date = Double.parseDouble(last.getDate());
    		                current_date = Double.parseDouble(m.getDate());
        					
    		                // Recent measure has been found
    		                if(last_date < current_date) { last = m; }
        				}
        			}
        		}
        		
        		// Exists a measureType
        		if(last != null) {
        			list_measure.add(last);
        		}
        	}
	        
	        // Convert a list of Measure in a list of MeasureBean..
	        List<MeasureBean> list_measureBean = new ArrayList<>();
	        for (Measure m : list_measure) {
	            MeasureBean mb = new MeasureBean();
	            mb.setCreated(m.getDate());
	            mb.setMeasureType(m.getIdmt().getMeasurename());
	            mb.setIdp(m.getIdp().getIdPerson());
	            mb.setMid(m.getMid());
	            mb.setValue(m.getValue());
	            list_measureBean.add(mb);
	        }
	        hp.setMeasure(list_measureBean);
	        
        } catch(Exception e) {
        	System.err.println("Exception in getHealthProfileFromMeasureList()");
        	e.printStackTrace();
        }
        return hp;
    }
}