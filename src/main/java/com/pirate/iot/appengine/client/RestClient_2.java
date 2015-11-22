package com.pirate.iot.appengine.client;

import com.pirate.iot.appengine.entities.SensorTag;
import com.pirate.iot.appengine.virtual.Virtualizer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Do multiple data insrtion to the server
 */
public class RestClient_2 {

    private static final String WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON = "E://projects/iot-appengine/src/main/webapp/WEB-INF/raw_data/sensortag_set_2.json";
    private static final int NUMBER_OF_DATA_ADDED = 5;
    Client client = Client.create();

    String postUrl = "http://localhost:8080/rest/sensortag/";


    public void postRequest(SensorTag data) {
        WebResource webResource = client.resource(postUrl);

        String inputData = "";

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);
        if (response.getStatus() != 201) {
            throw new RuntimeException("HTTP Error: " + response.getStatus());
        }

        String result = response.getEntity(String.class);
        System.out.println("Response from the Server: ");
        System.out.println(result);
    }

    public static void main(String[] args) {
        RestClient_2 restClient = new RestClient_2();
        Virtualizer virtualizer = new Virtualizer(WEB_INF_RAW_DATA_SENSORTAG_SET_2_JSON);
        List list = virtualizer.build();

        Random randomGenerator = new Random();
        int index = 0;

        List subList = new ArrayList();

        if(NUMBER_OF_DATA_ADDED <= list.size()) {
            while(subList.size() < NUMBER_OF_DATA_ADDED)
            {
                index = randomGenerator.nextInt(list.size());
                if(!subList.contains(list.get(index))) {
                    SensorTag data = (SensorTag) list.get(index);
                    subList.add(list.get(index));

                    System.out.println(data);
                    restClient.postRequest(data);
                }
            }
        }
    }
}