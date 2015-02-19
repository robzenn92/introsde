/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introsde.document.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author roberto
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Person {
    
    private long personId;

    private String lastname;
    
    private String firstname;
    
    private String birthdate;
    
    private List<Measure> currentHealth;

    public List<Measure> getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(List<Measure> currentHealth) {
        this.currentHealth = currentHealth;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Person() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}