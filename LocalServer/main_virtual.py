from flask import Flask, jsonify
from tools import Tools
import sys
from uuid import getnode as get_mac


#Be sure you aren't using any aliases for urlib !!!
import urllib3.request

# Initialize the Flask application
app = Flask(__name__)

## ROUTES ##

@app.route('/getdata', methods=['GET'])
def getData():
    list = tools.virtual_data_sensors()

    return list


@app.route('/getsensorslist', methods=['GET'])
def getSensorList():

    # TODO get list from z1
    return 'GetSensorsList called'


if __name__ == '__main__':

    uuid = get_mac()

    #For local deployement
    if sys.argv[2] == '0':
        port = '4242'
    else:
        port = sys.argv[2]

    tools = Tools(sys.argv[1],sys.argv[2])
    tools.register_local(uuid)

    app.run(
        host="0.0.0.0",
        port=int(port)
    )
