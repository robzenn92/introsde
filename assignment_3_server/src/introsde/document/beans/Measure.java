/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsde.document.beans;

import introsde.st.Settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author roberto
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Measure{
    
    
    private int mid;
    
    private double measureValue;
    
    private String dateRegistered;
    
    private String measureType;
    
    private String measureValueType;

    public String getMeasureValueType() {
        return measureValueType;
    }

    public void setMeasureValueType(String measureValueType) {
        this.measureValueType = measureValueType;
    }
    
    public Measure(){
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }
    

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public double getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(double measureValue) {
        this.measureValue = measureValue;
    }

    public String getDateRegistered() {
        return Settings.convDate(dateRegistered);
    }
    
    /*@XmlElement(name = "created")
    public String getNiceDate() {
        return St.convDate(created);
    }*/

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }


    @Override
    public String toString() {
        return mid + " " + measureValue+ " " + dateRegistered+ " " + measureType;
    }
}