package com.pirate.iot.appengine.virtual;

import com.pirate.iot.appengine.utility.Fetch;
import com.pirate.iot.appengine.entities.Pi;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;

/**
 * Created by kamyh on 23.11.15.
 */
public class VirtualFetch extends Fetch {

    @Override
    public void fetchFrom(String piUrl) {
        String url = "http://localhost:8080/rest/sensortag/random/5";

        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource(url);

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

    @Override
    public ArrayList<Pi> getListPis()
    {
        CreateRessourcesVirtual createRessourcesVirtual = new CreateRessourcesVirtual();
        return createRessourcesVirtual.getPiList();
    }
}
