package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public Pi(String externalURL, String uUID, String friendlyName, String registerDate) {
        this.externalURL = externalURL;
        this.uUID = uUID;
        this.friendlyName = friendlyName;
        this.registerDate = registerDate;
    }

    public Pi(JSONObject data) {
        this.externalURL = data.getString("externalURL");
        this.uUID = data.getString("uUID");
        this.friendlyName = data.getString("friendlyName");
        this.registerDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
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
        Entity pi = new Entity("Pi",uUID);

        // assign properties to entity
        pi.setProperty("externalURL", externalURL);
        pi.setProperty("uUID", uUID);
        pi.setProperty("friendlyName", friendlyName);
        pi.setProperty("registerDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:S").format(new Date()));

        // store entity in datastore
        datastore.put(pi);
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