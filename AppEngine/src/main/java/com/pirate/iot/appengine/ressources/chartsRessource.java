package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.virtual.CreateRessourcesVirtual;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/charts/")
public class chartsRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    @GET
    @Consumes("application/json")
    @Path("/mag/{uuid}")
    public List fakeRegisters(@PathParam("uuid") String uuid)
    {
        List list = new ArrayList();

        //TODO get from datastore

        return list;
    }
}