# Project
The purpose of this project is to follow your pet's habits. Put in your cat or dog neckless the sensors and get some informations about them (how much do they walk per day (not yet implemented), temperature, etc).

Our project : [http://1.iot-pirate.appspot.com/](http://1.iot-pirate.appspot.com/)
Take a look at our Wiki : [Wiki](https://github.com/MichaelCaraccio/iot-appengine/wiki)

![iot website project](http://www.mcaraccio.ch/assets/img/iot_website2.png)

### Software
The Data collection for Internet of Things run on Google App Engine.

### Harware
* Zolertia Z1  [Zolertia website](http://zolertia.io/z1)
* TI Sensortag [TI website](http://www.ti.com/ww/en/wireless_connectivity/sensortag2015/)
* Raspberry PI [RaspberryPi website](https://www.raspberrypi.org/)

![iot website project](http://www.mcaraccio.ch/assets/img/iotmontage.png)

### Three main folders
 * **AppEngine** : Source code for your application AppEngine
 * **Contiki** : Source code for your Z1 and Sensortag
 * **Localserver** : Source code for your RaspberryPi

## 1. Deploy you Local Server (RapsberryPi)

### 1.1 Setup
#### 1.1.1 Requirements
```bash
sudo apt-get install python python-pip
sudo pip install flask
pip install urllib3
pip install requests
```
### 1.2 Deploy	
- Retrieve the sources from our repository
- Copy the default directory
- Modify the config.cfgg file

Property  | Description
------------- | -------------
auto_external  | Set it to false if you have a domain name and write your domain url in "external" field
external  | Your domain name (if you got one)
port | Flask port. It need to be open by your firewall
distant_ip | App Engine application URL
friendly_name | A simple name for your server

**Example:**
```
[general]
auto_external: true 	
external: 
port: 1234 		
distant_ip: http://1.iot-pirate.appspot.com 
friendly_name: deruaz_home
```

- Modify the main to add the sensors (virtual or real sensors)
**Example:**

```python
# Add a virtual sensor
tools.add_sensor(Sensor_tag_virtual( 'Lassie', '23fa8287-a719-4c1b-8177-7ec829f6e08r', '6Lowpan', 0, "2015-12-05 11:03:06"))
# Add a real sensor (Sensortag)
tools.add_sensor(Sensor_tag_real("Simba", '01111111-a719-4c1b-8177-7ec829d6e02a', '6Lowpan', 1, "2013-04-05 11:03:06", "http://[aaaa::c30c:0:0:1560]/"))
```

### 1.3 Running It

- Make start.sh executable
```bash
sudo chmod +x start.sh
```
- Modify start.sh to run the main with the right .cfg file
```bash
sudo nano start.sh
```
- Run start.sh	
```bash
./start.sh
```

## 2. Z1 and Sensortag
If you need more informations about how to set up Instant Contiki and compile your Zolertia Z1 or Sensortag -> [Wiki](https://github.com/MichaelCaraccio/iot-appengine/wiki)

