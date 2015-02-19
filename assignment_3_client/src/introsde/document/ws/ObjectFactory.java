
package introsde.document.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.document.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReadPersonMeasurement_QNAME = new QName("http://ws.document.introsde/", "readPersonMeasurement");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://ws.document.introsde/", "updatePersonResponse");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://ws.document.introsde/", "deletePersonResponse");
    private final static QName _ReadPersonHistoryResponse_QNAME = new QName("http://ws.document.introsde/", "readPersonHistoryResponse");
    private final static QName _ReadPerson_QNAME = new QName("http://ws.document.introsde/", "readPerson");
    private final static QName _SavePersonMeasurementResponse_QNAME = new QName("http://ws.document.introsde/", "savePersonMeasurementResponse");
    private final static QName _ReadMeasureTypesResponse_QNAME = new QName("http://ws.document.introsde/", "readMeasureTypesResponse");
    private final static QName _ReadMeasureTypes_QNAME = new QName("http://ws.document.introsde/", "readMeasureTypes");
    private final static QName _ReadPersonListResponse_QNAME = new QName("http://ws.document.introsde/", "readPersonListResponse");
    private final static QName _CreatePerson_QNAME = new QName("http://ws.document.introsde/", "createPerson");
    private final static QName _ReadPersonHistory_QNAME = new QName("http://ws.document.introsde/", "readPersonHistory");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://ws.document.introsde/", "createPersonResponse");
    private final static QName _SavePersonMeasurement_QNAME = new QName("http://ws.document.introsde/", "savePersonMeasurement");
    private final static QName _ReadPersonResponse_QNAME = new QName("http://ws.document.introsde/", "readPersonResponse");
    private final static QName _DeletePerson_QNAME = new QName("http://ws.document.introsde/", "deletePerson");
    private final static QName _ReadPersonMeasurementResponse_QNAME = new QName("http://ws.document.introsde/", "readPersonMeasurementResponse");
    private final static QName _UpdatePerson_QNAME = new QName("http://ws.document.introsde/", "updatePerson");
    private final static QName _ReadPersonList_QNAME = new QName("http://ws.document.introsde/", "readPersonList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.document.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurementResponse }
     * 
     */
    public ReadPersonMeasurementResponse createReadPersonMeasurementResponse() {
        return new ReadPersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link SavePersonMeasurement }
     * 
     */
    public SavePersonMeasurement createSavePersonMeasurement() {
        return new SavePersonMeasurement();
    }

    /**
     * Create an instance of {@link ReadPersonResponse }
     * 
     */
    public ReadPersonResponse createReadPersonResponse() {
        return new ReadPersonResponse();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link ReadPersonList }
     * 
     */
    public ReadPersonList createReadPersonList() {
        return new ReadPersonList();
    }

    /**
     * Create an instance of {@link ReadPerson }
     * 
     */
    public ReadPerson createReadPerson() {
        return new ReadPerson();
    }

    /**
     * Create an instance of {@link SavePersonMeasurementResponse }
     * 
     */
    public SavePersonMeasurementResponse createSavePersonMeasurementResponse() {
        return new SavePersonMeasurementResponse();
    }

    /**
     * Create an instance of {@link ReadPersonMeasurement }
     * 
     */
    public ReadPersonMeasurement createReadPersonMeasurement() {
        return new ReadPersonMeasurement();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonHistoryResponse }
     * 
     */
    public ReadPersonHistoryResponse createReadPersonHistoryResponse() {
        return new ReadPersonHistoryResponse();
    }

    /**
     * Create an instance of {@link ReadPersonListResponse }
     * 
     */
    public ReadPersonListResponse createReadPersonListResponse() {
        return new ReadPersonListResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link ReadPersonHistory }
     * 
     */
    public ReadPersonHistory createReadPersonHistory() {
        return new ReadPersonHistory();
    }

    /**
     * Create an instance of {@link ReadMeasureTypes }
     * 
     */
    public ReadMeasureTypes createReadMeasureTypes() {
        return new ReadMeasureTypes();
    }

    /**
     * Create an instance of {@link ReadMeasureTypesResponse }
     * 
     */
    public ReadMeasureTypesResponse createReadMeasureTypesResponse() {
        return new ReadMeasureTypesResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Measure }
     * 
     */
    public Measure createMeasure() {
        return new Measure();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonMeasurement")
    public JAXBElement<ReadPersonMeasurement> createReadPersonMeasurement(ReadPersonMeasurement value) {
        return new JAXBElement<ReadPersonMeasurement>(_ReadPersonMeasurement_QNAME, ReadPersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonHistoryResponse")
    public JAXBElement<ReadPersonHistoryResponse> createReadPersonHistoryResponse(ReadPersonHistoryResponse value) {
        return new JAXBElement<ReadPersonHistoryResponse>(_ReadPersonHistoryResponse_QNAME, ReadPersonHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPerson")
    public JAXBElement<ReadPerson> createReadPerson(ReadPerson value) {
        return new JAXBElement<ReadPerson>(_ReadPerson_QNAME, ReadPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "savePersonMeasurementResponse")
    public JAXBElement<SavePersonMeasurementResponse> createSavePersonMeasurementResponse(SavePersonMeasurementResponse value) {
        return new JAXBElement<SavePersonMeasurementResponse>(_SavePersonMeasurementResponse_QNAME, SavePersonMeasurementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readMeasureTypesResponse")
    public JAXBElement<ReadMeasureTypesResponse> createReadMeasureTypesResponse(ReadMeasureTypesResponse value) {
        return new JAXBElement<ReadMeasureTypesResponse>(_ReadMeasureTypesResponse_QNAME, ReadMeasureTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadMeasureTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readMeasureTypes")
    public JAXBElement<ReadMeasureTypes> createReadMeasureTypes(ReadMeasureTypes value) {
        return new JAXBElement<ReadMeasureTypes>(_ReadMeasureTypes_QNAME, ReadMeasureTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonListResponse")
    public JAXBElement<ReadPersonListResponse> createReadPersonListResponse(ReadPersonListResponse value) {
        return new JAXBElement<ReadPersonListResponse>(_ReadPersonListResponse_QNAME, ReadPersonListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonHistory")
    public JAXBElement<ReadPersonHistory> createReadPersonHistory(ReadPersonHistory value) {
        return new JAXBElement<ReadPersonHistory>(_ReadPersonHistory_QNAME, ReadPersonHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonMeasurement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "savePersonMeasurement")
    public JAXBElement<SavePersonMeasurement> createSavePersonMeasurement(SavePersonMeasurement value) {
        return new JAXBElement<SavePersonMeasurement>(_SavePersonMeasurement_QNAME, SavePersonMeasurement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonResponse")
    public JAXBElement<ReadPersonResponse> createReadPersonResponse(ReadPersonResponse value) {
        return new JAXBElement<ReadPersonResponse>(_ReadPersonResponse_QNAME, ReadPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonMeasurementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonMeasurementResponse")
    public JAXBElement<ReadPersonMeasurementResponse> createReadPersonMeasurementResponse(ReadPersonMeasurementResponse value) {
        return new JAXBElement<ReadPersonMeasurementResponse>(_ReadPersonMeasurementResponse_QNAME, ReadPersonMeasurementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.document.introsde/", name = "readPersonList")
    public JAXBElement<ReadPersonList> createReadPersonList(ReadPersonList value) {
        return new JAXBElement<ReadPersonList>(_ReadPersonList_QNAME, ReadPersonList.class, null, value);
    }

}
