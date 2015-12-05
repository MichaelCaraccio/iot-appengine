from flask import Flask, jsonify
from tools import Tools
from uuid import getnode as get_mac
import sys
from sensor_tag_virtual import Sensor_tag_virtual

# Initialize the Flask application
app = Flask(__name__)

## ROUTES ##
@app.route('/getdata', methods=['GET'])
def getData():
    list = tools.get_data_sensors()
    print(list)
    return list


@app.route('/getsensorslist', methods=['GET'])
def getSensorList():

    list = tools.sensor_list()
    print(list)
    return list

## MAIN
if __name__ == '__main__':

    uuid = get_mac()

    tools = Tools(uuid,sys.argv[1])

    # param 2 --> UUID of an animal
    # sensor need to have a get_json() method
    #sensor need attributs name and uuid
    tools.add_sensor(Sensor_tag_virtual( 'virtual_1', '51fa8287-a719-4c1b-8177-7ec829f6e08e', 'BLE'))
    tools.add_sensor(Sensor_tag_virtual( 'virtual_2', '51fa8287-a719-4c1b-8177-7ec829f6e08r', 'BLE'))

    tools.register_local()

    app.run(
        host="0.0.0.0",
        port=int(tools.local_port)
    )
