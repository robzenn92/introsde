package introsde.client;

import introsde.document.ws.Measure;
import introsde.document.ws.People;
import introsde.document.ws.PeopleImplService;
import introsde.document.ws.Person;

import java.util.List;

public class PeopleClient {

    public static void main(String[] args) throws Exception {

        try {

			PeopleImplService s = new PeopleImplService();
			People people = s.getPeopleImplPort();
			
			// METHOD #1
			System.out.println(Settings.METH_01);
			List<Person> pList = people.readPersonList();
			
			System.err.println("Size: " + pList.size());
			
			System.out.println(Settings.RESULT + pList.toString());
			
			// METHOD #2
			System.out.println(Settings.METH_02);
			Person p2 = people.readPerson(pList.get(0).getPersonId());
			
			System.err.println("Size: " + pList.size());
			
			System.out.println(Settings.RESULT + p2);
			
			// METHOD #3
			System.out.println(Settings.METH_03);
			Person p3 = pList.get(0);
			long rob_id = p3.getPersonId();
			
			System.err.println("Last name " + p3.getFirstname());
			
			p3.setFirstname("Pavel");
			p3.setLastname("Zen");
			long res3 = people.updatePerson(p3);
			
			System.err.println("Last name " + p3.getFirstname());
			
			System.out.println(Settings.RESULT + res3); 
			
			// METHOD #4
			p2.setFirstname("Mario");
			p2.setLastname("Biondi");
			System.out.println(Settings.METH_04);
			Long id_last = people.createPerson(p2);
			System.out.println(Settings.RESULT + id_last); 
			
			// METHOD #5
			System.out.println(Settings.METH_05);
			p2.setPersonId(id_last);
			Long p5 = people.deletePerson(p2.getPersonId());
			System.out.println(Settings.RESULT + p5.toString());
			
			// METHOD #6
			System.out.println(Settings.METH_06);
			List<Measure> l_m = people.readPersonHistory(rob_id, "weight");
			System.out.println(Settings.RESULT  + people.readPersonHistory(rob_id, "weight"));
			
			System.err.println("COUNT BEFORE:" + l_m.size());
			
			// METHOD #7
			System.out.println(Settings.METH_07);
			Measure m = people.readPersonMeasurement(rob_id, "weight", new Long(l_m.get(0).getMid()));
			System.out.println(Settings.RESULT + m);
			
			// METHOD #8
			System.out.println(Settings.METH_08);
			long mid = people.savePersonMeasurement(rob_id, m);
			System.out.println(Settings.RESULT + mid);
			
			System.out.println(Settings.METH_06);
			l_m = people.readPersonHistory(rob_id, "weight");
			System.out.println(Settings.RESULT  + people.readPersonHistory(rob_id, "weight"));
			
			System.err.println("COUNT AFTER:" + l_m.size());
			
			// METHOD #9
			System.out.println(Settings.METH_09);
			System.out.println(Settings.RESULT + people.readMeasureTypes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}