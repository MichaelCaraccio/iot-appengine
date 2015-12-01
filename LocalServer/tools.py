import requests
import json
import urllib3, re
import ConfigParser


class Tools:
    def __init__(self):
        self.config = ConfigParser.ConfigParser()
        #TODO Check if config.cfg exist
        self.config.readfp(open('config.cfg'))

        self.ip_server = config.get("general", "distant_ip")
        self.local_port = config.get("general", "port")
        self.is_auto_ext = config.get("general", "external")

        if self.is_auto_ext:
            self.ip_local = "http://" + self.get_external_ip() + ':' + self.local_port
        else:
            self.ip_local = config.get("general", "external") + ':' + self.local_port

        print("Local IP: " + self.ip_local)
        print("Server IP: " + self.ip_server)

    def get_external_ip(self):
        site = requests.get("http://myip.dnsdynamic.org/")
        return site.text

    def virtual_data_sensors(self):
        r = requests.get(self.ip_server + '/rest/sensortag/random/5')
        return r.text

    def register_local(self, uuid):
        url = self.ip_server + '/rest/register/'
        payload = {
                 "externalURL":self.ip_local,
                 "uUID":uuid,
                 "friendlyName":"Pirate"
                 }
        headers = {'content-type': 'application/json'}

        response = requests.post(url, data=json.dumps(payload), headers=headers)

        print("Status Code: " + str(response.status_code))
