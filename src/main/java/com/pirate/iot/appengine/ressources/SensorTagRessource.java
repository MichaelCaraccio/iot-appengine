package com.pirate.iot.appengine.ressources;

import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/sensortag/")
public class SensorTagRessource {

    public static final String WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON = "WEB-INF/raw_data/sensortag_set_2.json";

    /**
     *
     * @param number
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/random/{number}/")
    public List getSensor(@PathParam ("number") int number) {

        Virtualizer virtualizer = new Virtualizer(WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON);
        List list = virtualizer.build();

        Random randomGenerator = new Random();
        int index = 0;

        List subList = new ArrayList();

        if(number <= list.size()) {
            while(subList.size() < number)
            {
                index = randomGenerator.nextInt(list.size());
                if(!subList.contains(list.get(index))) {
                    subList.add(list.get(index));
                }
            }

            return subList;
        }

        return null;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/test/")
    public List getTest() {

        Virtualizer virtualizer = new Virtualizer(WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON);
        List list = virtualizer.build();

        return list;
    }
}