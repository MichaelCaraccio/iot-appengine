from flask import Flask, jsonify
from tools import Tools
from uuid import getnode as get_mac
import sys

# Initialize the Flask application
app = Flask(__name__)

## ROUTES ##
@app.route('/getdata', methods=['GET'])
def getData():
    list = tools.get_data_sensors()

    return list


@app.route('/getsensorslist', methods=['GET'])
def getSensorList():

    # TODO get list from z1
    return 'GetSensorsList called <-- UNIMPLEMENTED'

## MAIN
if __name__ == '__main__':

    uuid = get_mac()

    tools = Tools(uuid,sys.argv[1])
    tools.register_local()

    app.run(
        host="0.0.0.0",
        port=int(tools.local_port)
    )
