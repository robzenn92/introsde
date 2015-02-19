package introsde.document.ws;

import introsde.document.beans.Measure;
import introsde.document.beans.Person;

import java.util.List;

import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.document.ws.People")
public class PeopleImpl implements People { 

	@Override
	public Person readPerson(Long id) {
		System.out.println("---> Reading Person by id = " + id);
		Person p = introsde.document.model.Person.getPersonBeanById(id.intValue());
		if (p!=null) {
			System.out.println("---> Found Person by id = " + id + " => " + p.getFirstname());
		} else {
			System.out.println("---> Didn't find any Person with  id = " + id);
		}
		return p;
	}

	@Override
	public List<Person> getPeople() {
		return introsde.document.model.Person.getAllPersonBean();
	}

	@Override
	public long addPerson(Person person) {
		introsde.document.model.Person.savePerson(person);
		return person.getPersonId();
	}

	@Override
	public Long updatePerson(Person person) {
		introsde.document.model.Person.updatePerson(person);
		return new Long(person.getPersonId());
	}

	@Override
	public Long deletePerson(Long id) {
		introsde.document.model.Person p = introsde.document.model.Person.getPersonById((id.intValue()));
		if (p!=null) {
			introsde.document.model.Person.removePerson(p);
			return new Long(p.getIdPerson());
		} else {
			return new Long(-1);
		}
	}

    @Override
    public List<Measure> readPersonHistory(Long id, String measureType) {
        return introsde.document.model.Measure.getAllForMeasureBeanType(id.intValue(), measureType);
    }

    @Override
    public Measure readPersonMeasurement(Long id, String measureType, Long mid) {
        Measure o = introsde.document.model.Measure.getMeasureBeanTypeById(id.intValue(), measureType, mid.intValue());
        return o;
    }

    @Override
    public long savePersonMeasurement(Long id, Measure m) {
        return introsde.document.model.Measure.saveMeasure(m,id).getMid();
    }

    @Override
    public List<String> readMeasureTypes() {
        return introsde.document.beans.MeasureTypeBean.getAll().getMeasureTypes();
    }

	@Override
	public Long updatePersonMeasure(Long id, Measure m) {
		return new Long(introsde.document.model.Measure.updateMeasure(m,id).getMid());
	}
}