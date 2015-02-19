/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introsde.document.model;

import introsde.document.beans.Person;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author roberto
 */
@XmlRootElement
public class People {
    
    ArrayList<Person> person = new ArrayList<>();

    public ArrayList<Person> getPerson() {
        return person;
    }

    public void setPerson(ArrayList<Person> person) {
        this.person = person;
    }
    
    public People(){
    }
}
