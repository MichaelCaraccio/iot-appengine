package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "animal")
public class Animal {

    private int race;
    private String uUID;
    private String name;
    private String age;

    public Animal() {

    }

    public Animal(int race, String uUID, String name) {
        this.race = race;
        this.uUID = uUID;
        this.name = name;
    }

    public Animal(int race, String uUID, String name, String age) {
        this.race = race;
        this.uUID = uUID;
        this.name = name;
        this.age = age;
    }

    public Animal(JSONObject data) {
        this.race = data.getInt("race");
        this.uUID = data.getString("uUID");
        this.name = data.getString("name");
        this.age = data.getString("age");
    }

    @XmlElement(name = "race")
    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    @XmlElement(name = "uUID")
    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void register(DatastoreService datastore)
    {
        //create entity type (kind) "Sensortag"
        Entity pi = new Entity("Animal",uUID);

        // assign properties to entity
        pi.setProperty("race", race);
        pi.setProperty("uUID", uUID);
        pi.setProperty("name", name);
        pi.setProperty("age", age);

        // store entity in datastore
        datastore.put(pi);
    }

    @Override
    public String toString() {
        return "{" +
                "\n \"race\":\"" + race + "\"," +
                "\n \"uUID\":" + uUID + "," +
                "\n \"name\":" + name + "," +
                "\n \"age\":" + age + "," +
                "\n}";
    }
}