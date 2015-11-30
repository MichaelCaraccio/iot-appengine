package com.pirate.iot.appengine.client;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.virtual.CreateRessourcesVirtual;

import java.util.ArrayList;

/**
 * Created by kamyh on 23.11.15.
 * USE THIS WITH CAUTION
 * Create fake pi in datastore for testing purpose in virtual mode
 */
public class populateFakePisDS {


    public static void main(String[] args) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        CreateRessourcesVirtual createRessourcesVirtual = new CreateRessourcesVirtual();
        ArrayList<Pi> piList = createRessourcesVirtual.getPiList();

        for (Pi pi:piList) {
            pi.register(datastore);
        }
    }
}
