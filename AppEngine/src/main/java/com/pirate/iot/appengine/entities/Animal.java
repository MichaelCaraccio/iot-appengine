package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "animal")
public class Animal {

    private int race;
    private String uUID;
    private String name;
    private String age;
    private String location;

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

    @XmlElement(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void register(DatastoreService datastore, String idLocal)
    {
        //create entity type (kind) "Sensortag"
        Entity animal = new Entity("Animal", this.uUID);

        // assign properties to entity
        animal.setProperty("race", race);
        animal.setProperty("uUID", this.uUID);
        animal.setProperty("name", name);
        animal.setProperty("age", age);
        animal.setProperty("location", idLocal);

        // store entity in datastore
        datastore.put(animal);
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