from flask import Flask, jsonify
from tools import Tools
from uuid import getnode as get_mac
import sys
from sensor_tag_virtual import Sensor_tag_virtual

# Initialize the Flask application
app = Flask(__name__)


## ROUTES ##

# Use to fetch all active sensors data (virtuel or not)
@app.route('/getdata', methods=['GET'])
def getData():
    list = tools.get_data_sensors()
    print(list)
    return list


# Use to fetch active sensor list
# App engine backend use it to record all pets, Front end purpose
@app.route('/getsensorslist', methods=['GET'])
def getSensorList():
    list = tools.sensor_list()
    print(list)
    return list


## MAIN

# sys.argv[1] has to be a .cfg file containing those info:
# [general]
# auto_external: true
# external: http://exemple.com
# port: 1234
# distant_ip: http://1.iot-pirate.appspot.com
# friendly_name: deruaz_home
if __name__ == '__main__':
    # local server machine Mac address is used as an UUID
    uuid = get_mac()

    tools = Tools(uuid, sys.argv[1])

    # param 2 --> UUID of an animal
    # sensor need to have a get_json() method
    # sensor need attributs name and uuid
    # tools.add_sensor(Sensor_tag_virtual( 'virtual_1', '51fa8287-a719-4c1b-8177-7ec829f6e08e', 'BLE'))
    tools.add_sensor(Sensor_tag_virtual( 'virtual_2', '51fa8287-a719-4c1b-8177-7ec829f6e08r', 'BLE', 0, "2015-12-05 11:03:06"))
    tools.add_sensor(Sensor_tag_virtual( 'real_1', '11112222-a319-4c1b-8177-6r7ew6qr8ew7', '6Lowpan', 0, "2015-01-03 11:03:06"))

    # tell to app Engine backend that data can be fetch from him
    tools.register_local()

    app.run(
        host="0.0.0.0",
        port=int(tools.local_port)
    )
