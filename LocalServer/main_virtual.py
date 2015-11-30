from flask import Flask, jsonify
from tools import Tools
import sys

#Be sure you aren't using any aliases for urlib !!!
import urllib3.request

# Initialize the Flask application
app = Flask(__name__)

## ROUTES ##

@app.route('/getdata', methods=['GET'])
def getData():

    tools = Tools()
    list = tools.virtual_data_sensors()

    return list


@app.route('/getsensorslist', methods=['GET'])
def getSensorList():

    # TODO get list from z1
    return 'GetSensorsList called'


if __name__ == '__main__':

    uuid = sys.argv[1]

    tools = Tools()
    tools.register_local(uuid)

    app.run(
        host="0.0.0.0",
        port=int("4242")
    )
