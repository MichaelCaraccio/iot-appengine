package com.pirate.iot.appengine.virtual;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.com.google.common.base.Charsets;
import com.google.appengine.repackaged.com.google.common.io.Files;
import com.pirate.iot.appengine.entities.SensorTag;
import org.json.JSONArray;


/**
 * Created by Vincent on 21.11.2015.
 */
public class Virtualizer {

    private String filename;

    public Virtualizer(String filename) {
        this.filename = filename;
    }

    public Virtualizer() {

    }

    public List build() {
        List list = new ArrayList();

        try {
            String content = Files.toString(new File(this.filename), Charsets.UTF_8);

            System.out.println(content);

            JSONArray sensortagList = new JSONArray(content);

            for (int i=0;i< sensortagList.length(); i++)
            {
                SensorTag sensorTag = new SensorTag(sensortagList.getJSONObject(i));

                list.add(sensorTag);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
