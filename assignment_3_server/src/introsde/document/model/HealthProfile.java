/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsde.document.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author roberto
 */
@XmlRootElement
public class HealthProfile implements Serializable {
    
    public static List<introsde.document.beans.Measure> getHelathProfileFromMeasureList(List<Measure> measure) {
        List<Measure> temp = new ArrayList<Measure>();
        try {
	        for (Measure mh : measure) {
	            boolean aux = true;
	            for (Measure mht : temp) {
	            	
		                double td = Double.parseDouble(mht.getDate());
		                double d = Double.parseDouble(mh.getDate());
		                if (mht.getIdmt() == mh.getIdmt()) {
		                    aux = false;
		                }
		                if (mht.getIdmt() == mh.getIdmt() && d > td) {
		                    temp.remove(mht);
		                    temp.add(mh);
		                }
	            	
	            }
	            if (aux) {
	                temp.add(mh);
	            }
	        }
         }catch(Exception e) {
    		e.printStackTrace();
    	}
        List<introsde.document.beans.Measure> tempB = new ArrayList<>();
        for (Measure m : temp) {
            introsde.document.beans.Measure mb = new introsde.document.beans.Measure();
            mb.setDateRegistered(m.getDate());
            mb.setMeasureType(m.getIdmt().getMeasurename());
            mb.setMid(m.getMid());
            mb.setMeasureValue(m.getValue());
            mb.setMeasureValueType(m.getIdmt().getMeasureValueType());
            tempB.add(mb);
        }
        return tempB;
    }
}