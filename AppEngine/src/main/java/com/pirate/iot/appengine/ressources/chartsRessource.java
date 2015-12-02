package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.*;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.CreateRessourcesVirtual;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Path("/charts/")
public class chartsRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    @GET
    @Produces("application/json")
    @Path("/all/{uuid}")
    public ArrayList<SensorTag> getAll(@PathParam("uuid") String uuid) {
        return getSensorTags(uuid);
    }

    private ArrayList<SensorTag> getSensorTags(String uuid) {
        ArrayList<SensorTag> list = new ArrayList<SensorTag>();

        //TODO Limit number of result
        Query q = new Query("Sensortag");
        Query.Filter uuidFilter =
                new Query.FilterPredicate("guid",
                        Query.FilterOperator.EQUAL,
                        uuid);
        q.setFilter(uuidFilter);

        //Last 1 day
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

        //TODO maybe use a parameter from URI
        cal.add(Calendar.DATE, -1);

        Query.Filter DateFilter =
                new Query.FilterPredicate("date",
                        Query.FilterOperator.GREATER_THAN_OR_EQUAL,
                        dateFormat.format(cal.getTime()));
        q.setFilter(DateFilter);

        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());

        for(Entity entity: results)
        {
            SensorTag sensorTag = new SensorTag(
                    (String)entity.getProperty("guid"),
                    (Boolean)entity.getProperty("isActivate"),
                    (Double)entity.getProperty("pressure"),
                    (Double)entity.getProperty("pressure_t"),
                    (Double)entity.getProperty("humidity"),
                    (Double)entity.getProperty("humidity_t"),
                    (Double)entity.getProperty("objtemp"),
                    (Double)entity.getProperty("accelX"),
                    (Double)entity.getProperty("accelY"),
                    (Double)entity.getProperty("accelZ"),
                    (Double)entity.getProperty("gyroX"),
                    (Double)entity.getProperty("gyroY"),
                    (Double)entity.getProperty("gyroY"),
                    (Double)entity.getProperty("magX"),
                    (Double)entity.getProperty("magY"),
                    (Double)entity.getProperty("magZ"),
                    (Double)entity.getProperty("light"),
                    (Double)entity.getProperty("battery"),
                    ((Long)entity.getProperty("key1")).intValue(),
                    ((Long)entity.getProperty("key2")).intValue(),
                    ((Long)entity.getProperty("reed")).intValue(),
                    ((Long)entity.getProperty("buzzer")).intValue(),
                    ((Long)entity.getProperty("LED1")).intValue(),
                    ((Long)entity.getProperty("LED2")).intValue(),
                    (String)entity.getProperty("Radio")
            );

            sensorTag.setDatetime((String)entity.getProperty("date"));

            list.add(sensorTag);
        }
        return list;
    }
}