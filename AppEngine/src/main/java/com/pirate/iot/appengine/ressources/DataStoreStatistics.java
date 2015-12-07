package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * racine for all stats related routes
 * used for FrontEnd
 */
@Path("/stats")
public class DataStoreStatistics {
    /**
     * @return
     */
    @GET
    public Response fetchAll() {

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity globalStat = datastore.prepare(new Query("__Stat_Total__")).asSingleEntity();
        Long totalEntities = (Long) globalStat.getProperty("count");

        return Response.status(201).entity(totalEntities).build();
    }
}