package com.pirate.iot.appengine.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient_1 {

    Client client = Client.create();
    String postUrl = "http://localhost:8080/rest/sensortag/";


    public void postRequest() {
        WebResource webResource = client.resource(postUrl);
        String inputData = "{\n" +
                "    \"guid\": \"9e4dbb09-6111-44b0-ac1f-19fcaa0e3ef3\",\n" +
                "    \"isActive\": true,\n" +
                "    \"pressure\": 2464.23,\n" +
                "    \"pressure_t\": 1671.53,\n" +
                "    \"humidity\": 1981.44,\n" +
                "    \"humidity_t\": 818.4,\n" +
                "    \"objtemp\": 3564.67,\n" +
                "    \"accelX\": 2616.39,\n" +
                "    \"accelY\": 1464.78,\n" +
                "    \"accelZ\": 2752.19,\n" +
                "    \"gyroX\": 1419.2,\n" +
                "    \"gyroY\": 743.02,\n" +
                "    \"gyroZ\": 337.13,\n" +
                "    \"magX\": 2066.36,\n" +
                "    \"magY\": 296.96,\n" +
                "    \"magZ\": 2325.2,\n" +
                "    \"light\": 3353.2,\n" +
                "    \"battery\": 48.09,\n" +
                "    \"key1\": 8,\n" +
                "    \"key2\": 4,\n" +
                "    \"reed\": 10,\n" +
                "    \"buzzer\": 0,\n" +
                "    \"LED1\": 0,\n" +
                "    \"LED2\": 1,\n" +
                "    \"Radio\": \"WIFI\"\n" +
                "  }";
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, inputData);
        if (response.getStatus() != 201) {
            throw new RuntimeException("HTTP Error: " + response.getStatus());
        }

        String result = response.getEntity(String.class);
        System.out.println("Response from the Server: ");
        System.out.println(result);
    }

    public static void main(String[] args) {
        RestClient_1 restClient = new RestClient_1();

        restClient.postRequest();
    }
}