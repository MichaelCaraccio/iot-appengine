from flask import Flask, jsonify
from tools import Tools

#Be sure you aren't using any aliases for urlib !!!
import urllib3.request

# Initialize the Flask application
app = Flask(__name__)

## ROUTES ##

@app.route('/getdata', methods=['GET'])
def getData():
    list = [
        {'param': 'foo', 'val': 2},
        {'param': 'bar', 'val': 10}
    ]

    tools = Tools()
    tools.virtual_data_sensors()

    return jsonify(measures=list)


@app.route('/getsensorslist', methods=['GET'])
def getSensorList():

    # TODO get list from z1
    return 'GetSensorsList called'


if __name__ == '__main__':

    app.run(
        host="0.0.0.0",
        port=int("4242")
    )
