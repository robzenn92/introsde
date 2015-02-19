/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secondassignement.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import secondassignement.model.MeasureTypeBean;

/**
 *handle the request of path measureTypes
 * @author roberto
 */
@Stateless
@LocalBean
@Path("/measureTypes")
public class MeasureTypeResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    /**
     * returns the list of measuretypes in database
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public MeasureTypeBean getMeasureTypesXml() {
        System.out.println("Getting list of measures type...");
        MeasureTypeBean measuretype = MeasureTypeBean.getAll();
        return measuretype;
    }
}