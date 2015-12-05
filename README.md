# iot-appengine
Data collection backend for Internet of Things on Google App Engine using TI SensorTag and Zolertia Z1

# Local Server Deploy

## Setup

### Requierments
		sudo apt-get install python python-pip
		sudo pip install flask
		pip install urllib3
		pip install requests
		
## Deploy	

- Retrieve the sources from our repository
- Copy the default directory
- Modify the config.cfgg file
		[general]
		auto_external: true //if you have a domaine name put false here and write it to the "external" field
		external: http://exemple.com	//if you want to use a domaine name
		port: 1234 //the flask port. It need to be open in your firewall
		distant_ip: http://1.iot-pirate.appspot.com //App Engine application URL
		friendly_name: deruaz_home	//a simple name for your server
- Modify the main to add the sensors

## Running It

- Make start.sh executable
- Modify start.sh to run the main with the right .cfg file
- Run start.sh		
