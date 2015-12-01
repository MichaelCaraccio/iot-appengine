import requests
import json
import urllib3, re

class Tools:
    def __init__(self,ip_server,local_port):
        self.ip_server = ip_server
        self.local_port = local_port

        if(local_port == '0'):
            #for local testing
            self.ip_local = "http://localhost:4242"
        else:
            self.ip_local = "http://" + self.get_external_ip() + ':' + self.local_port

        print("Local IP: " + self.ip_local)

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
