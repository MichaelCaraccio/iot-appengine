package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Fetch;
import com.pirate.iot.appengine.entities.Pi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/fetch")
public class FetchRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    private Fetch fetch;

    /**
     * @return
     */
    @GET
    public Response fetchAll() {
        //TODO change if no virtual
        //this.fetch = new VirtualFetch();
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