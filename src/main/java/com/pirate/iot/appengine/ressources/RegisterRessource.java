package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/register/")
public class RegisterRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    /**
     *
     * @return
     */
    @POST
    @Consumes("application/json")
    @Path("/")
    public Response postSensorTag(Pi pi) {
        String result = "Successfully Register";

        pi.register(datastore);

        return Response.status(201).entity(result).build();
    }
}