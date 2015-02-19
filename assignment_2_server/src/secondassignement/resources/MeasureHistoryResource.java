/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.resources;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import secondassignement.model.Measure;
import secondassignement.model.MeasureType;

/**
 *
 * @author roberto
 */
@Stateless
@LocalBean
@Path("/measureHistory")
public class MeasureHistoryResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Measure> getPersonsBrowser() {
        System.out.println("Getting list of measures history...");
        List<Measure> measureHistory = Measure.getAll();
        return measureHistory;
    }
    
    @GET
    @Path("{personId}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Measure> getPerson(@PathParam("personId") int id) {
        System.out.println("Getting list of measures type for " + id );
        List<Measure> measureHistory = Measure.getAll(id);
        System.err.println("finalli");
        return measureHistory;
    }
}