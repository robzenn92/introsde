/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class that maps a person in xml or json
 *
 */

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonBean {
    
    private int idp;

    private String lastname;
    
    private String firstname;
    
    private String birthdate;
    
    @XmlElement(name = "healthProfile")
    private HealthProfile healthprofile;

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    PersonBean() {
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

    public HealthProfile getHealthprofile() {
        return healthprofile;
    }

    public void setHealthprofile(HealthProfile healthprofile) {
        this.healthprofile = healthprofile;
    }
}