# iot-appengine
Data collection backend for Internet of Things on Google App Engine using TI SensorTag and Zolertia Z1

###Three folders
 * **AppEngine** : Source code for your application AppEngine
 * **Contiki** : Source code for your Z1 and Sensortag
 * **Localserver** : Source code for your RaspberryPi

## 1. Deploy you Local Server (RapsberryPi)

### Setup
#### Requirements
```bash
sudo apt-get install python python-pip
sudo pip install flask
pip install urllib3
pip install requests
```
### Deploy	

- Retrieve the sources from our repository
- Copy the default directory
- Modify the config.cfgg file
 

Property  | Description
------------- | -------------
auto_external  | if you have a domaine name put false here and write it to the "external" field
external  | if you want to use a domaine name
port | the flask port. It need to be open in your firewall
distant_ip | App Engine application URL
friendly_name | A simple name for your server

Example:
```
[general]
auto_external: true 	
external: http://exemple.com	
port: 1234 		
distant_ip: http://1.iot-pirate.appspot.com 
friendly_name: deruaz_home
```

- Modify the main to add the sensors (virtual or real sensors)
Example:

```python
# Add a virtual sensor
tools.add_sensor(Sensor_tag_virtual( 'Lassie', '23fa8287-a719-4c1b-8177-7ec829f6e08r', '6Lowpan', 0, "2015-12-05 11:03:06"))
# Add a real sensor (Sensortag)
tools.add_sensor(Sensor_tag_real("Simba", '01111111-a719-4c1b-8177-7ec829d6e02a', '6Lowpan', 1, "2013-04-05 11:03:06", "http://[aaaa::c30c:0:0:1560]/"))
```

### Running It

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

