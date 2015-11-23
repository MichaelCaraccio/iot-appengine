package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "pi")
public class Pi {

    private String externalURL;
    private String uUID;
    private String friendlyName;
    private String registerDate;

    public Pi() {

    }

    public Pi(String externalURL, String uUID, String friendlyName) {
        this.externalURL = externalURL;
        this.uUID = uUID;
        this.friendlyName = friendlyName;
    }

    @XmlElement(name = "externalURL")
    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    @XmlElement(name = "uUID")
    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }

    @XmlElement(name = "friendlyName")
    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @XmlElement(name = "registerDate")
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public void register(DatastoreService datastore)
    {
        //create entity type (kind) "Sensortag"
        Entity sensorTag = new Entity("Pi");

        // assign properties to entity
        sensorTag.setProperty("externalURL", externalURL);
        sensorTag.setProperty("uUID", uUID);
        sensorTag.setProperty("friendlyName", friendlyName);
        sensorTag.setProperty("registerDate", registerDate);

        // store entity in datastore
        datastore.put(sensorTag);
    }

    @Override
    public String toString() {
        return "{" +
                "\n \"externalURL\":\"" + externalURL + "\"," +
                "\n \"uUID\":" + uUID + "," +
                "\n \"friendlyName\":" + friendlyName + "," +
                "\n \"registerDate\":" + registerDate + "," +
                "\n}";
    }
}