package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.*;
import com.pirate.iot.appengine.entities.Animal;
import com.pirate.iot.appengine.entities.Pi;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * racine for all animals related routes
 * used for FrontEnd
 */
@Path("/animals/")
public class AnimalsRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    /**
     * Default route for /animals
     *
     * @return
     */
    @GET
    @Produces("application/json")
    public HashMap<String, List> fetchAll() {
        List subList = new ArrayList();
        HashMap<String, List> result = new HashMap<String,List>();

        result.put("animals",this.getAnimals());

        return result;
    }

    /**
     * Retrive all animals stored in datastore
     * @return ArrayList<Animal>
     */
    private ArrayList<Animal> getAnimals() {
        ArrayList<Animal> list = new ArrayList<Animal>();

        //TODO Limit number of result
        Query q = new Query("Animal");

        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());

        for(Entity entity: results)
        {
            Animal animal = new Animal(
                    ((Long)entity.getProperty("race")).intValue(),
                    (String)entity.getProperty("uUID"),
                    (String)entity.getProperty("name"),
                    (String)entity.getProperty("age")
            );

            Query qPi = new Query("Pi");
            Query.Filter PiFilter =
                    new Query.FilterPredicate("uUID",
                            Query.FilterOperator.EQUAL,
                            entity.getProperty("location"));
            qPi.setFilter(PiFilter);

            List<Entity> resultsPi = datastore.prepare(qPi).asList(FetchOptions.Builder.withDefaults());

            if(resultsPi.size() > 0) {
                animal.setLocation((new Pi(
                        (String) resultsPi.get(0).getProperty("externalURL"),
                        (String) resultsPi.get(0).getProperty("uUID"),
                        (String) resultsPi.get(0).getProperty("friendlyName"),
                        (String) resultsPi.get(0).getProperty("registerDate")

                )));
            }

            list.add(animal);
        }
        return list;
    }
}