from flask import Flask, jsonify
from tools import Tools
from uuid import getnode as get_mac

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
    return 'GetSensorsList called <-- UNIMPLEMENTED'


if __name__ == '__main__':

    uuid = get_mac()

    tools = Tools()
    tools.register_local(uuid)

    app.run(
        host="0.0.0.0",
        port=int(tools.local_port)
    )
