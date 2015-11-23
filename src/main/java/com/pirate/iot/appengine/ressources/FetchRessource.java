package com.pirate.iot.appengine.ressources;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/fetch/")
public class FetchRessource {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    public Response fetchAll() {
        //TODO get List PIs
        //TODO foreach PI
            //TODO call to get URI to retrieved sensors data
            //TODO foreach Sensor
                //TODO parse into SensorTag entity
                //TODO put in datastore

        return Response.status(201).entity("HELLO").build();
    }

    /**
     * Retrieved all datas sensors from a specific PI
     * @param piUrl
     */
    protected void fetchFrom(String piUrl)
    {
        //TODO
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
        //TODO
        JSONArray sensortagList = new JSONArray(data);

        for (int i=0;i< sensortagList.length(); i++)
        {
            SensorTag sensorTag = new SensorTag(sensortagList.getJSONObject(i));

            System.out.println(sensorTag);
            //TODO call sensorTag.toDatastore(DatastoreService datastore)
        }
    }

    protected ArrayList<Pi> getListPis()
    {
        ArrayList<Pi> pis = new ArrayList<>();

        //TODO get list from datastore

        return pis;
    }
}