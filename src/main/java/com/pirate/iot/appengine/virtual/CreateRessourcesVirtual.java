package com.pirate.iot.appengine.virtual;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.pirate.iot.appengine.entities.Pi;
import com.pirate.iot.appengine.entities.SensorTag;
import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by kamyh on 23.11.15.
 * USE THIS WITH CAUTION
 * Create fake pi in datastore for testing purpose in virtual mode
 */
public class CreateRessourcesVirtual {

    private ArrayList<Pi> piList;
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public CreateRessourcesVirtual()
    {
        this.build();

        for (Pi pi:piList) {
            pi.register(datastore);
        }
    }

    private void build()
    {
        String json = "[\n" +
                "  {\n" +
                "    \"externalURL\": \"http://ex.com\",\n" +
                "    \"uUID\": \"51fa8287-a719-4c1b-8177-7ec829f6e08e\",\n" +
                "    \"friendlyName\": \"amet\",\n" +
                "    \"registerDate\": \"2014-05-26T01:17:18 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://officia.com\",\n" +
                "    \"uUID\": \"a0e6e2c0-a326-4b20-978e-3c38da3350cd\",\n" +
                "    \"friendlyName\": \"proident\",\n" +
                "    \"registerDate\": \"2015-04-03T09:23:02 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://fugiat.com\",\n" +
                "    \"uUID\": \"2c72c9a7-47d6-419a-b33a-8b060492bd39\",\n" +
                "    \"friendlyName\": \"esse\",\n" +
                "    \"registerDate\": \"2014-03-18T06:42:23 -01:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://ea.com\",\n" +
                "    \"uUID\": \"81163969-6028-4805-81d3-42ab4f563b20\",\n" +
                "    \"friendlyName\": \"tempor\",\n" +
                "    \"registerDate\": \"2015-07-06T05:13:19 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://duis.com\",\n" +
                "    \"uUID\": \"da29fc97-9f28-47cb-bfa6-7e884a61c791\",\n" +
                "    \"friendlyName\": \"reprehenderit\",\n" +
                "    \"registerDate\": \"2014-10-11T02:43:29 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://reprehenderit.com\",\n" +
                "    \"uUID\": \"57c2066a-438b-410e-9db2-02caa175980d\",\n" +
                "    \"friendlyName\": \"Lorem\",\n" +
                "    \"registerDate\": \"2014-12-01T04:22:49 -01:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://qui.com\",\n" +
                "    \"uUID\": \"2efe20ce-f6d6-4c82-b17d-e8c141a8ec7b\",\n" +
                "    \"friendlyName\": \"ea\",\n" +
                "    \"registerDate\": \"2015-07-22T03:15:01 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://voluptate.com\",\n" +
                "    \"uUID\": \"0387062e-e1a2-42f0-a490-1543a979b152\",\n" +
                "    \"friendlyName\": \"eu\",\n" +
                "    \"registerDate\": \"2014-01-08T07:06:53 -01:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://consectetur.com\",\n" +
                "    \"uUID\": \"e0785d50-fd13-4ac5-a620-501a92b4c4a5\",\n" +
                "    \"friendlyName\": \"eu\",\n" +
                "    \"registerDate\": \"2014-10-13T05:35:40 -02:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"externalURL\": \"http://velit.com\",\n" +
                "    \"uUID\": \"c397bc6c-94a0-4303-9282-d1638da02670\",\n" +
                "    \"friendlyName\": \"adipisicing\",\n" +
                "    \"registerDate\": \"2015-03-11T10:37:02 -01:00\"\n" +
                "  }\n" +
                "]";

        JSONArray piListJson = new JSONArray(json);

        for (int i=0;i< piListJson.length(); i++)
        {
            Pi pi = new Pi(piListJson.getJSONObject(i));

            piList.add(pi);
        }
    }


    public ArrayList<Pi> getPiList() {
        return piList;
    }

    public void setPiList(ArrayList<Pi> piList) {
        this.piList = piList;
    }
}
