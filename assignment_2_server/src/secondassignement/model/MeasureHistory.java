/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
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
