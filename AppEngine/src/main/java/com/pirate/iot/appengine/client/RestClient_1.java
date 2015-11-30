package com.pirate.iot.appengine.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * DO a simple unique call to the POST data methode
 */
public class RestClient_1 {

    Client client = Client.create();
    String postUrl = "http://localhost:8080/rest/sensortag/";

    public void postRequest() {
        WebResource webResource = client.resource(postUrl);
        /*String inputData = "{\n" +
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
                "  }";*/
        String inputData = "{\n" +
                " \"guid\":\"e0a8cd5c-8b83-47d7-87f7-939ffaa6971a\",\n" +
                " \"isActive\":false,\n" +
                " \"pressure\":347.63,\n" +
                " \"pressure_t\":3151.93,\n" +
                " \"humidity\":1150.2,\n" +
                " \"humidity_t\":2008.25,\n" +
                " \"objtemp\":879.07,\n" +
                " \"accelX\":1433.14,\n" +
                " \"accelY\":3133.47,\n" +
                " \"accelZ\":8.29,\n" +
                " \"gyroX\":1424.71,\n" +
                " \"gyroY\":3029.88,\n" +
                " \"gyroZ\":518.79,\n" +
                " \"magX\":1676.0,\n" +
                " \"magY\":1780.08,\n" +
                " \"magZ\":2389.28,\n" +
                " \"light\":3248.24,\n" +
                " \"battery\":56.1,\n" +
                " \"key1\":3,\n" +
                " \"key2\":10,\n" +
                " \"reed\":8,\n" +
                " \"buzzer\":1,\n" +
                " \"LED1\":1,\n" +
                " \"LED2\":1,\n" +
                " \"Radio\":\"WIFI\"\n" +
                "}";
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