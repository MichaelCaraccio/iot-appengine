from flask import Flask
from tools import Tools
from uuid import getnode as get_mac
import sys
from sensor_tag_real import Sensor_tag_real

# Initialize the Flask application
app = Flask(__name__)
app.debug = True

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

if __name__ == '__main__':
    # local server machine Mac address is used as an UUID
    uuid = get_mac()

    tools = Tools(uuid, sys.argv[1])

    tools.add_sensor(Sensor_tag_real("Simba", '01111111-a719-4c1b-8177-7ec829d6e02a', '6Lowpan', 1, "2013-04-05 11:03:06", "http://[aaaa::c30c:0:0:1560]/"))

    # tell to app Engine backend that data can be fetch from him
    tools.register_local()

    app.run(
        host="0.0.0.0"#,
        #port=int(tools.local_port)
    )
