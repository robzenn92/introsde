package introsde.document.ws;
import introsde.document.beans.Measure;
import introsde.document.beans.Person;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface People {
	
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="id") Long id);
 
    @WebMethod(operationName="readPersonList")
    @WebResult(name="person")
    public List<Person> getPeople();
 
    @WebMethod(operationName="createPerson")
    @WebResult(name="personId") 
    public long addPerson(@WebParam(name="person") Person person);
 
    @WebMethod(operationName="updatePerson")
    @WebResult(name="personId") 
    public Long updatePerson(@WebParam(name="person") Person person);
    
    @WebMethod(operationName="deletePerson")
    @WebResult(name="personId") 
    public Long deletePerson(@WebParam(name="id") Long id);
    
    @WebMethod(operationName="readPersonHistory")
    @WebResult(name="measurehistory") 
    public List<Measure> readPersonHistory(@WebParam(name="id")Long id, @WebParam(name="measureType") String measureType);
    
    @WebMethod(operationName="readPersonMeasurement")
    @WebResult(name="measure") 
    public Measure readPersonMeasurement(@WebParam(name="id") Long id,  @WebParam(name="measureType") String measureType, @WebParam(name="mid") Long mid);
    
    @WebMethod(operationName="savePersonMeasurement")
    @WebResult(name="mid") 
    public long savePersonMeasurement(@WebParam(name="id")Long id, @WebParam(name="m") Measure m);
    
    @WebMethod(operationName="readMeasureTypes")
    @WebResult(name="mid") 
    public List<String> readMeasureTypes();
    
    @WebMethod(operationName="updatePersonMeasure")
    @WebResult(name="mid") 
    public Long updatePersonMeasure(@WebParam(name="id") Long id, @WebParam(name="m") Measure m);
}