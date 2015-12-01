package com.pirate.iot.appengine.entities;

import com.google.appengine.api.datastore.*;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@XmlRootElement(name = "sensortag")
public class SensorTag {

    private String guid;
    private Boolean isActive;
    //Pressure sensor air pressure - hPa
    private double pressure;
    //Pressure sensor temperature - C
    private double pressure_t;
    //Humidity sensor relative humidity - %RH
    private double humidity;
    //Humidity sensor temperature - C
    private double humidity_t;
    //IR temp sensor object temperature - C
    private double objtemp;
    //Accelerometer X-axis motion - g
    private double accelX;
    //Accelerometer Y-axis motion - g
    private double accelY;
    //Accelerometer Z-axis motion - g
    private double accelZ;
    //Gyroscope X-axis rotation - deg/sec
    private double gyroX;
    //Gyroscope Y-axis rotation - deg/sec
    private double gyroY;
    //Gyroscope Z-axis rotation - deg/sec
    private double gyroZ;
    //Magnetometer X-axis magnetic field - uT
    private double magX;
    //Magnetometer Y-axis magnetic field - uT
    private double magY;
    //Magnetometer Z-axis magnetic field - uT
    private double magZ;
    //Light sensor illuminance - Lux
    private double light;
    //Battery voltage level - mV
    private double battery;
    //Push button 1 key value - state
    private int key1;
    //Push button 2 key value - state
    private int key2;
    //Magnet reed relay state value - state
    private int reed;
    //Buzzer on/off - state
    private int buzzer;
    //LED1 state on/off - state
    private int led1;
    //LED2 state on/off - state
    private int led2;
    //Radio interface(BLE/Wifi) - string
    private String radio;

    public SensorTag() {

    }

    public SensorTag(String radio, double pressure, double pressure_t, double humidity, double humidity_t, double objtemp, double accelX, double accelY, double accelZ, double gyroX, double gyroY, double gyroZ, double magX, double magY, double magZ, double light, double battery, int key1, int key2, int reed, int buzzer, int led1, int led2) {
        this.radio = radio;
        this.pressure = pressure;
        this.pressure_t = pressure_t;
        this.humidity = humidity;
        this.humidity_t = humidity_t;
        this.objtemp = objtemp;
        this.accelX = accelX;
        this.accelY = accelY;
        this.accelZ = accelZ;
        this.gyroX = gyroX;
        this.gyroY = gyroY;
        this.gyroZ = gyroZ;
        this.magX = magX;
        this.magY = magY;
        this.magZ = magZ;
        this.light = light;
        this.battery = battery;
        this.key1 = key1;
        this.key2 = key2;
        this.reed = reed;
        this.buzzer = buzzer;
        this.led1 = led1;
        this.led2 = led2;
    }

    public SensorTag(String guid, Boolean isActive, double pressure, double pressure_t, double humidity, double humidity_t, double objtemp, double accelX, double accelY, double accelZ, double gyroX, double gyroY, double gyroZ, double magX, double magY, double magZ, double light, double battery, int key1, int key2, int reed, int buzzer, int led1, int led2, String radio) {
        this.guid = guid;
        this.isActive = isActive;
        this.pressure = pressure;
        this.pressure_t = pressure_t;
        this.humidity = humidity;
        this.humidity_t = humidity_t;
        this.objtemp = objtemp;
        this.accelX = accelX;
        this.accelY = accelY;
        this.accelZ = accelZ;
        this.gyroX = gyroX;
        this.gyroY = gyroY;
        this.gyroZ = gyroZ;
        this.magX = magX;
        this.magY = magY;
        this.magZ = magZ;
        this.light = light;
        this.battery = battery;
        this.key1 = key1;
        this.key2 = key2;
        this.reed = reed;
        this.buzzer = buzzer;
        this.led1 = led1;
        this.led2 = led2;
        this.radio = radio;
    }

    public SensorTag(JSONObject data) {
        this.guid = data.getString("guid");
        this.isActive = data.getBoolean("isActive");
        this.pressure = data.getDouble("pressure");
        this.pressure_t = data.getDouble("pressure_t");
        this.humidity = data.getDouble("humidity");
        this.humidity_t = data.getDouble("humidity_t");
        this.objtemp = data.getDouble("objtemp");
        this.accelX = data.getDouble("accelX");
        this.accelY = data.getDouble("accelY");
        this.accelZ = data.getDouble("accelZ");
        this.gyroX = data.getDouble("gyroX");
        this.gyroY = data.getDouble("gyroY");
        this.gyroZ = data.getDouble("gyroZ");
        this.magX = data.getDouble("magX");
        this.magY = data.getDouble("magY");
        this.magZ = data.getDouble("magZ");
        this.light = data.getDouble("light");
        this.battery = data.getDouble("battery");
        this.key1 = data.getInt("key1");
        this.key2 = data.getInt("key2");
        this.reed = data.getInt("reed");
        this.buzzer = data.getInt("buzzer");
        this.led1 = data.getInt("LED1");
        this.led2 = data.getInt("LED2");
        this.radio = data.getString("Radio");
    }


    @XmlElement(name = "guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlElement(name = "isActive")
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @XmlElement(name = "pressure")
    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @XmlElement(name = "pressure_t")
    public double getPressure_t() {
        return pressure_t;
    }

    public void setPressure_t(double pressure_t) {
        this.pressure_t = pressure_t;
    }

    @XmlElement(name = "humidity")
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @XmlElement(name = "humidity_t")
    public double getHumidity_t() {
        return humidity_t;
    }

    public void setHumidity_t(double humidity_t) {
        this.humidity_t = humidity_t;
    }

    @XmlElement(name = "objtemp")
    public double getObjtemp() {
        return objtemp;
    }

    public void setObjtemp(double objtemp) {
        this.objtemp = objtemp;
    }

    @XmlElement(name = "accelX")
    public double getAccelX() {
        return accelX;
    }

    public void setAccelX(double accelX) {
        this.accelX = accelX;
    }

    @XmlElement(name = "accelY")
    public double getAccelY() {
        return accelY;
    }

    public void setAccelY(double accelY) {
        this.accelY = accelY;
    }

    @XmlElement(name = "accelZ")
    public double getAccelZ() {
        return accelZ;
    }

    public void setAccelZ(double accelZ) {
        this.accelZ = accelZ;
    }

    @XmlElement(name = "gyroX")
    public double getGyroX() {
        return gyroX;
    }

    public void setGyroX(double gyroX) {
        this.gyroX = gyroX;
    }

    @XmlElement(name = "gyroY")
    public double getGyroY() {
        return gyroY;
    }

    public void setGyroY(double gyroY) {
        this.gyroY = gyroY;
    }

    @XmlElement(name = "gyroZ")
    public double getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(double gyroZ) {
        this.gyroZ = gyroZ;
    }

    @XmlElement(name = "magX")
    public double getMagX() {
        return magX;
    }

    public void setMagX(double magX) {
        this.magX = magX;
    }

    @XmlElement(name = "magY")
    public double getMagY() {
        return magY;
    }

    public void setMagY(double magY) {
        this.magY = magY;
    }

    @XmlElement(name = "magZ")
    public double getMagZ() {
        return magZ;
    }

    public void setMagZ(double magZ) {
        this.magZ = magZ;
    }

    @XmlElement(name = "light")
    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    @XmlElement(name = "battery")
    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    @XmlElement(name = "key1")
    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    @XmlElement(name = "key2")
    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    @XmlElement(name = "reed")
    public int getReed() {
        return reed;
    }

    public void setReed(int reed) {
        this.reed = reed;
    }

    @XmlElement(name = "buzzer")
    public int getBuzzer() {
        return buzzer;
    }

    public void setBuzzer(int buzzer) {
        this.buzzer = buzzer;
    }

    @XmlElement(name = "LED1")
    public int getLed1() {
        return led1;
    }

    public void setLed1(int led1) {
        this.led1 = led1;
    }

    @XmlElement(name = "LED2")
    public int getLed2() {
        return led2;
    }

    public void setLed2(int led2) {
        this.led2 = led2;
    }

    @XmlElement(name = "Radio")
    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public void toDatastore(DatastoreService datastore)
    {
        //create entity type (kind) "Sensortag"
        Entity sensorTag = new Entity("Sensortag");

        // assign properties to entity
        sensorTag.setProperty("guid", guid);
        sensorTag.setProperty("isActive", isActive);
        sensorTag.setProperty("pressure", pressure);
        sensorTag.setProperty("pressure_t", pressure_t);
        sensorTag.setProperty("humidity", humidity);
        sensorTag.setProperty("humidity_t", humidity_t);
        sensorTag.setProperty("objtemp", objtemp);
        sensorTag.setProperty("accelX", accelX);
        sensorTag.setProperty("accelY", accelY);
        sensorTag.setProperty("accelZ", accelZ);
        sensorTag.setProperty("gyroX", gyroX);
        sensorTag.setProperty("gyroY", gyroY);
        sensorTag.setProperty("gyroZ", gyroZ);
        sensorTag.setProperty("magX", magX);
        sensorTag.setProperty("magY", magY);
        sensorTag.setProperty("magZ", magZ);
        sensorTag.setProperty("light", light);
        sensorTag.setProperty("battery", battery);
        sensorTag.setProperty("key1", key1);
        sensorTag.setProperty("key2", key2);
        sensorTag.setProperty("reed", reed);
        sensorTag.setProperty("buzzer", buzzer);
        sensorTag.setProperty("LED1", led1);
        sensorTag.setProperty("LED2", led2);
        sensorTag.setProperty("Radio", radio);
        sensorTag.setProperty("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:S").format(new Date()));

        // store entity in datastore
        datastore.put(sensorTag);
    }

    @Override
    public String toString() {
        return "{" +
                "\n \"guid\":\"" + guid + "\"," +
                "\n \"isActive\":" + isActive + "," +
                "\n \"pressure\":" + pressure + "," +
                "\n \"pressure_t\":" + pressure_t + "," +
                "\n \"humidity\":" + humidity + "," +
                "\n \"humidity_t\":" + humidity_t + "," +
                "\n \"objtemp\":" + objtemp + "," +
                "\n \"accelX\":" + accelX + "," +
                "\n \"accelY\":" + accelY + "," +
                "\n \"accelZ\":" + accelZ + "," +
                "\n \"gyroX\":" + gyroX + "," +
                "\n \"gyroY\":" + gyroY + "," +
                "\n \"gyroZ\":" + gyroZ + "," +
                "\n \"magX\":" + magX + "," +
                "\n \"magY\":" + magY + "," +
                "\n \"magZ\":" + magZ + "," +
                "\n \"light\":" + light + "," +
                "\n \"battery\":" + battery + "," +
                "\n \"key1\":" + key1 + "," +
                "\n \"key2\":" + key2 + "," +
                "\n \"reed\":" + reed + "," +
                "\n \"buzzer\":" + buzzer + "," +
                "\n \"LED1\":" + led1 + "," +
                "\n \"LED2\":" + led2 + "," +
                "\n \"Radio\":\"" + radio + "\"" +
                "\n}";
    }
}