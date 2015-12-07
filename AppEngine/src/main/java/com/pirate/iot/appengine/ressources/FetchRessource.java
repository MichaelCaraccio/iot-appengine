package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.utility.Fetch;
import com.pirate.iot.appengine.entities.Pi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * racine for all fetching routes
 * used for Backend
 * This route is used by a cron job to fetch from all registered local server the sensors data
 */
@Path("/fetch")
public class FetchRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    private Fetch fetch;

    /**
     * Default route
     * @return Response
     */
    @GET
    public Response fetchAll() {
        this.fetch = new Fetch();

        //get List PIs
        ArrayList<Pi> listPi = this.fetch.getListPis();
        //foreach PI
        for (Pi pi : listPi) {
            //call to get URI to retrieved sensors data
            this.fetch.fetchFrom(pi.getExternalURL());
            System.out.println("FETCH " + pi.getExternalURL());
        }

        return Response.status(201).entity("SUCCESS").build();
    }
}