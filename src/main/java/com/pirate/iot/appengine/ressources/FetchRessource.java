package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/fetch/")
public class FetchRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    public Response fetchAll() {
        //TODO get List PIs
        //TODO foreach PI
            //TODO call to get URI to retrieved sensors data
            //TODO foreach Sensor
                //TODO parse into SensorTag entity
                //TODO put in datastore

        return Response.status(201).entity("HELLO").build();
    }

    /**
     * Retrieved all datas sensors from a specific PI
     * @param piUrl
     */
    private void fetchFrom(String piUrl)
    {
        //TODO
    }

    /**
     * parse all retrieved datas
     * @param data
     */
    private void parse(String data)
    {
        //TODO
    }
}