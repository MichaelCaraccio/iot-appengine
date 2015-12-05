import requests
import json
import urllib3, re
import ConfigParser
from sensor_tag_virtual import Sensor_tag_virtual


#####                                 #####
# Handle all configurations and setup env #
#                                         #
#####                                 #####
class Tools:
    def __init__(self, uuid, config_filename):
        self.uuid = uuid
        self.config = ConfigParser.ConfigParser()
        # TODO Check if config.cfg exist
        self.config.readfp(open(config_filename))

        self.ip_server = self.config.get("general", "distant_ip")
        self.local_port = self.config.get("general", "port")
        self.is_auto_ext = self.config.get("general", "auto_external")
        self.friendly_name = self.config.get("general", "friendly_name")

        if self.is_auto_ext == 'true' or self.is_auto_ext == 'True':
            self.ip_local = "http://" + self.get_external_ip() + ':' + self.local_port
        else:
            self.ip_local = self.config.get("general", "external") + ':' + self.local_port

        print("Is Auto External Addr: " + self.is_auto_ext)
        print("Local Ip: " + self.ip_local)
        print("Server Ip: " + self.ip_server)

        self.sensors = []

        # param 2 --> UUID of an animal
        self.sensors.append(
            Sensor_tag_virtual(self.friendly_name + '_1', '51fa8287-a719-4c1b-8177-7ec829f6e08e', 'BLE'))
        self.sensors.append(
            Sensor_tag_virtual(self.friendly_name + '_1', '51fa8287-a719-4c1b-8177-7ec829f6e08r', 'BLE'))

    def get_external_ip(self):
        site = requests.get("http://myip.dnsdynamic.org/")
        return site.text

    def get_data_sensors(self):
        result = {'measures': []}

        for sensor in self.sensors:
            # All captor type need to have a get_json() methode
            result["measures"].append(sensor.get_json())

        return json.dumps(result)

    def register_local(self):

        url = self.ip_server + '/rest/register/'
        payload = {
            "externalURL": self.ip_local,
            "uUID": self.uuid,
            "friendlyName": self.friendly_name
        }
        headers = {'content-type': 'application/json'}

        response = requests.post(url, data=json.dumps(payload), headers=headers)

        print("Status Code: " + str(response.status_code))
