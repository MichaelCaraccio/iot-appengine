package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamyh on 23.11.15.
 */
public class Fetch {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();


    /**
     * Retrieved all datas sensors from a specific PI
     * @param piUrl
     */
    public void fetchFrom(String piUrl)
    {
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource(piUrl + "/getdata");


            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

            this.parse(output);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * parse all retrieved datas
     * @param data <-- JSON Table []
     */
    protected void parse(String data)
    {
        JSONObject obj = new JSONObject(data);
        JSONArray sensortagList = obj.getJSONArray("measures");

        for (int i=0;i< sensortagList.length(); i++)
        {
            SensorTag sensorTag = new SensorTag(sensortagList.getJSONObject(i));

            System.out.println(sensorTag);
            //TODO call sensorTag.toDatastore(DatastoreService datastore)
            sensorTag.toDatastore(datastore);
        }
    }

    public ArrayList<Pi> getListPis()
    {
        ArrayList<Pi> pis = new ArrayList<>();

        Query q = new Query("Pi");
        List<Entity> results = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());

        for(Entity entity: results)
        {
            Pi pi = new Pi((String)entity.getProperty("externalURL"), (String)entity.getProperty("uUID"), (String)entity.getProperty("friendlyName"), (String)entity.getProperty("registerDate"));
            pis.add(pi);
        }

        return pis;
    }
}
