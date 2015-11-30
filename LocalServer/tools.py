import requests
import json

class Tools:

    def virtual_data_sensors(self):
        r = requests.get('http://localhost:8080/rest/sensortag/random/5')
        return r.text

    def register_local(self, uuid):
        #TODO get external ip address
        ip = 'http://localhost:4242'
        ip = ip + '/register/'

        url = 'http://localhost:8080/rest/register/'
        payload = {
                 "externalURL":ip,
                 "uUID":uuid,
                 "friendlyName":"Pirate"
                 }
        headers = {'content-type': 'application/json'}

        response = requests.post(url, data=json.dumps(payload), headers=headers)

        print(response.status_code)
