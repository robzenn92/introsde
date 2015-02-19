/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsde.document.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class wrapper that map a lit of measures
 * @author roberto
 */

@XmlRootElement
public class MeasureHistory {
    
    List<Measure> measure = new ArrayList<>();
    
    public List<Measure> getMeasure() {
        return measure;
    }

    public void setMeasure(List<Measure> mh) {
        this.measure = mh;
    }
    
    public MeasureHistory(){
    }
    
}
