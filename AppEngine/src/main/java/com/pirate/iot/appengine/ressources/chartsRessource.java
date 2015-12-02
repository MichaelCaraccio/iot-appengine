package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.virtual.CreateRessourcesVirtual;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/charts/")
public class chartsRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

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