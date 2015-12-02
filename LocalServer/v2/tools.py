import requests
import json
import urllib3, re
import ConfigParser
from sensor_tag import Sensor_tag

#####                                 #####
# Handle all configurations and setup env #
#                                         #
#####                                 #####
class Tools:
    def __init__(self):
        self.config = ConfigParser.ConfigParser()
        #TODO Check if config.cfg exist
        self.config.readfp(open('config.cfg'))

        self.ip_server = self.config.get("general", "distant_ip")
        self.local_port = self.config.get("general", "port")
        self.is_auto_ext = self.config.get("general", "external")
        self.friendly_name = self.config.get("general", "friendly_name")

        if self.is_auto_ext:
            self.ip_local = "http://" + self.get_external_ip() + ':' + self.local_port
        else:
            self.ip_local = self.config.get("general", "external") + ':' + self.local_port

        print("Local IP: " + self.ip_local)
        print("Server IP: " + self.ip_server)

        #TODO make a list
        self.sensor = Sensor_tag(self.friendly_name + '_1',self.uuid,'BLE')

    def get_external_ip(self):
        site = requests.get("http://myip.dnsdynamic.org/")
        return site.text

    def virtual_data_sensors(self):
        str = self.sensor.get_json()
        print(str)
        return str

    def register_local(self, uuid):
        self.uuid = uuid
        url = self.ip_server + '/rest/register/'
        payload = {
                 "externalURL":self.ip_local,
                 "uUID":uuid,
                 "friendlyName":self.friendly_name
                 }
        headers = {'content-type': 'application/json'}

        response = requests.post(url, data=json.dumps(payload), headers=headers)

        print("Status Code: " + str(response.status_code))
