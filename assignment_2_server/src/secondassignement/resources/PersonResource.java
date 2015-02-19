package secondassignement.resources;

import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import secondassignement.model.Measure;
import secondassignement.model.MeasureBean;
import secondassignement.model.MeasureHistory;
import secondassignement.model.People;
import secondassignement.model.Person;
import secondassignement.model.PersonBean;

@Stateless
@LocalBean
@Path("/person")
/**
 * This class need to handle all request on path /parson/something
 */
public class PersonResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public People getPersonsBrowser() {
        System.out.println("Getting list of people...");
        People people = Person.getAllPersonBean();
        return people;
    }

    /**
     * 
     * @return the count off all people
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        System.out.println("Getting count...");
        List<Person> people = Person.getAll();
        int count = people.size();
        return String.valueOf(count);
    }

    /**
     * handle request of /person/id
     * @return the xml or json of that person
     */
    @GET
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getPerson(@PathParam("personId") int id) {
        System.out.println("Reading person from DB with id: " + id);
        PersonBean person = null;
        Response res;
        try {
            person = Person.getPersonBeanById(id);
            res = Response.accepted().entity(person).build();
        } catch (Exception e) {
            res = Response.status(404).build();
        }
        System.out.println(res);
        return res;
    }

    /**
     *  handle request of /person/id/measuretype
     * @return the xml or json of that person and that required measuretype
     */
    @GET
    @Path("{personId}/{measureType}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public MeasureHistory getMeasurement(@PathParam("personId") int id, @PathParam("measureType") String mt) {
        System.out.println("Reading measurement from DB with idp: " + id + " for " + mt);
        return Measure.getAllForMeasureType(id, mt);
    }

    /**
     * handle request of /person/id
     * @return the xml or json of that measureid for that person
     */
    @GET
    @Path("{personId}/{measureType}/{mid}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Measure getMeasurementById(@PathParam("personId") int id,
            @PathParam("measureType") String mt,
            @PathParam("mid") int mid) {
        System.out.println("Reading measurement from DB with idp: " + id + " for " + mt);
        return Measure.getMeasureTypeById(id, mt, mid);
    }

    /**
     * @param handle the POST request of /person and create 1 new
     * @return the xml or json of that person
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonBean newPerson(PersonBean personB) throws IOException {
        System.out.println("Creating new person...");
        PersonBean p = Person.savePerson(personB);
        return p;
    }

    /**
     * handle POST request of /person/id/measuretype and create a new mesure for taht person
     * @return the xml or json of that measure
     */
    @POST
    @Path("{personId}/{measureType}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public MeasureBean addMeasure(@PathParam("personId") int id, @PathParam("measureType") String mt, MeasureBean mb) throws IOException {
        System.out.println("Creating new measure...");
        //PersonBean p = Person.savePerson(personB);
        mb.setIdp(id);
        mb.setMeasureType(mt);
        Measure.saveMeasure(mb);
        return mb;
    }

    /**
     *  handle PUT request of /person/id and modify it
     * @return the xml or json of that person
     */
    @PUT
    @Path("{personId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response putPerson(PersonBean personB, @PathParam("personId") int id) {
        System.out.println("--> Updating Person... " + id);
        System.out.println("--> " + personB.toString());

        Response res;

        Person p = Person.getPersonById(id);
        if (p == null) {
            res = Response.noContent().build();
        } else {
            res = Response.accepted().build();

            personB.setIdp(id);
            Person.updatePerson(personB);
        }
        return res;

    }

    /**
     * Delete the person that has id equal to personId
     */
    @DELETE
    @Path("{personId}")
    public void deletePerson(@PathParam("personId") int id) {
        Person c = Person.getPersonById(id);
        if (c == null) {
            throw new RuntimeException("Delete: Person with " + id + " not found");
        }
        Person.removePerson(c);
    }
}