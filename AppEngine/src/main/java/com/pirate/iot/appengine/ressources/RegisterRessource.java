package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.CreateRessourcesVirtual;
import com.pirate.iot.appengine.virtual.Virtualizer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * racine for all registering related routes
 * used for BackEnd
 */
@Path("/register/")
public class RegisterRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    /**
     * Default route
     * @return Response
     */
    @POST
    @Consumes("application/json")
    public Response postSensorTag(Pi pi) {
        String result = "Successfully Register";

        System.out.println(pi);

        //Register Pi in datastore
        pi.register(datastore);

        //TODO check if really added in ds
        return Response.status(201).entity(result).build();
    }

    /**
     * for dev purpose only
     * @return Response
     */
    @GET
    @Consumes("application/json")
    @Path("/fake")
    public Response fakeRegisters()
    {
        CreateRessourcesVirtual createRessourcesVirtual = new CreateRessourcesVirtual();
        ArrayList<Pi> piList = createRessourcesVirtual.getPiList();

        for (Pi pi:piList) {
            pi.register(datastore);
        }

        return Response.status(201).entity("FAKE").build();
    }
}