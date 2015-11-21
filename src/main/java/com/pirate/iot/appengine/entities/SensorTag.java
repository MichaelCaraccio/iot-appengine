package com.pirate.iot.appengine.entities;

import org.json.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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


    @XmlElement
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlElement
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @XmlElement
    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @XmlElement
    public double getPressure_t() {
        return pressure_t;
    }

    public void setPressure_t(double pressure_t) {
        this.pressure_t = pressure_t;
    }

    @XmlElement
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @XmlElement
    public double getHumidity_t() {
        return humidity_t;
    }

    public void setHumidity_t(double humidity_t) {
        this.humidity_t = humidity_t;
    }

    @XmlElement
    public double getObjtemp() {
        return objtemp;
    }

    public void setObjtemp(double objtemp) {
        this.objtemp = objtemp;
    }

    @XmlElement
    public double getAccelX() {
        return accelX;
    }

    public void setAccelX(double accelX) {
        this.accelX = accelX;
    }

    @XmlElement
    public double getAccelY() {
        return accelY;
    }

    public void setAccelY(double accelY) {
        this.accelY = accelY;
    }

    @XmlElement
    public double getAccelZ() {
        return accelZ;
    }

    public void setAccelZ(double accelZ) {
        this.accelZ = accelZ;
    }

    @XmlElement
    public double getGyroX() {
        return gyroX;
    }

    public void setGyroX(double gyroX) {
        this.gyroX = gyroX;
    }

    @XmlElement
    public double getGyroY() {
        return gyroY;
    }

    public void setGyroY(double gyroY) {
        this.gyroY = gyroY;
    }

    @XmlElement
    public double getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(double gyroZ) {
        this.gyroZ = gyroZ;
    }

    @XmlElement
    public double getMagX() {
        return magX;
    }

    public void setMagX(double magX) {
        this.magX = magX;
    }

    @XmlElement
    public double getMagY() {
        return magY;
    }

    public void setMagY(double magY) {
        this.magY = magY;
    }

    @XmlElement
    public double getMagZ() {
        return magZ;
    }

    public void setMagZ(double magZ) {
        this.magZ = magZ;
    }

    @XmlElement
    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    @XmlElement
    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    @XmlElement
    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    @XmlElement
    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    @XmlElement
    public int getReed() {
        return reed;
    }

    public void setReed(int reed) {
        this.reed = reed;
    }

    @XmlElement
    public int getBuzzer() {
        return buzzer;
    }

    public void setBuzzer(int buzzer) {
        this.buzzer = buzzer;
    }

    @XmlElement
    public int getLed1() {
        return led1;
    }

    public void setLed1(int led1) {
        this.led1 = led1;
    }

    @XmlElement
    public int getLed2() {
        return led2;
    }

    public void setLed2(int led2) {
        this.led2 = led2;
    }

    @XmlElement
    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "SensorTag{" +
                ", guid='" + guid + '\'' +
                ", isActive=" + isActive +
                ", pressure=" + pressure +
                ", pressure_t=" + pressure_t +
                ", humidity=" + humidity +
                ", humidity_t=" + humidity_t +
                ", objtemp=" + objtemp +
                ", accelX=" + accelX +
                ", accelY=" + accelY +
                ", accelZ=" + accelZ +
                ", gyroX=" + gyroX +
                ", gyroY=" + gyroY +
                ", gyroZ=" + gyroZ +
                ", magX=" + magX +
                ", magY=" + magY +
                ", magZ=" + magZ +
                ", light=" + light +
                ", battery=" + battery +
                ", key1=" + key1 +
                ", key2=" + key2 +
                ", reed=" + reed +
                ", buzzer=" + buzzer +
                ", led1=" + led1 +
                ", led2=" + led2 +
                ", radio='" + radio + '\'' +
                '}';
    }
}