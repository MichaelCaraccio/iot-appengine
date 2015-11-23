package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Fetch;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.VirtualFetch;
import com.pirate.iot.appengine.virtual.Virtualizer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/fetch/")
public class FetchRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    private Fetch fetch;

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    public Response fetchAll() {
        this.fetch = new VirtualFetch();

        //get List PIs
        ArrayList<Pi> listPi = this.fetch.getListPis();
        //foreach PI
        for (Pi pi:listPi) {
            //call to get URI to retrieved sensors data
            this.fetch.fetchFrom(pi.getExternalURL());
        }

        return Response.status(201).entity("SUCCESS").build();
    }


}