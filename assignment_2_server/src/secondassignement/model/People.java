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
public class People {
    
    ArrayList<PersonBean> person = new ArrayList<>();
    
    public People(){ }

    public ArrayList<PersonBean> getPerson() {
        return person;
    }

    public void setPerson(ArrayList<PersonBean> person) {
        this.person = person;
    }
}