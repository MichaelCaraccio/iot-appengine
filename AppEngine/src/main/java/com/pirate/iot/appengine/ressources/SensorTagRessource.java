package com.pirate.iot.appengine.ressources;

import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * racine for all measures related routes
 * used for FrontEnd
 */
@Path("/sensortag/")
public class SensorTagRessource {

    public static final String WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON = "WEB-INF/raw_data/sensortag_set_2.json";

    /**
     * For dev purpose
     * Return a set of randomize data from a json file
     * @param number
     * @return HashMap<String, List> measures
     */
    @GET
    @Produces("application/json")
    @Path("/random/{number}/")
    public HashMap<String, List> getSensor(@PathParam ("number") int number) {

        Virtualizer virtualizer = new Virtualizer(WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON);
        List list = virtualizer.build();

        Random randomGenerator = new Random();
        int index = 0;

        List subList = new ArrayList();
        HashMap<String, List> result = new HashMap<String,List>();

        if(number <= list.size()) {
            while(subList.size() < number)
            {
                index = randomGenerator.nextInt(list.size());
                if(!subList.contains(list.get(index))) {
                    subList.add(list.get(index));
                }
            }

            result.put("measures",subList);

            return result;
        }

        return null;
    }

    /**
     * For dev purpose
     * Return a set of randomize data from a json file
     * @return SensorTag
     */
    @GET
    @Produces("application/json")
    @Path("/random/")
    public SensorTag getOneSensor() {

        Virtualizer virtualizer = new Virtualizer(WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON);
        List list = virtualizer.build();

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(list.size());

        return (SensorTag)list.get(index);
    }

    /**
     * Default route
     * dev purpose
     * @return Response
     */
    @POST
    @Consumes("application/json")
    public Response postSensorTag(SensorTag sensorTag) {
        String result = "Record entered: "+ sensorTag;

        return Response.status(201).entity(result).build();
    }
}