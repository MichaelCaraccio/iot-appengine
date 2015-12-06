import json
import datetime
import urllib3

class Sensor_tag_real:
    ### Sensor interface ##
    ## attributs:
    # name  -> String
    # age   -> String -> "yyyy-MM-dd HH:mm:S"
    # race  -> int -> 0 = dog, 1 = cat
    # uuid  -> unique identifier
    ## methods
    # get_json() -> return a json with all measures

    def __init__(self, name, uuid, radio, race, age, url):
        self.name = name
        self.age = age
        self.race = race
        self.uuid = uuid
        self.radio = radio
        self.init_sensor()
        self.url = url

    def init_sensor(self):
        self.pressure = 0
        self.pressure_t = 0
        self.humidity = 0
        self.humidity_t = 0
        self.objtemp = 0
        self.accel_x = 0
        self.accel_y = 0
        self.accel_z = 0
        self.gyro_x = 0
        self.gyro_y = 0
        self.gyro_z = 0
        self.mag_x = 0
        self.mag_y = 0
        self.mag_z = 0
        self.light = 0
        self.battery = 0
        self.key1 = 0
        self.key2 = 0
        self.reed = 0
        self.buzzer = 0
        self.led_1 = 0
        self.led_2 = 0

    def get_guid(self):
        return self.uuid

    def get_is_activated(self):
        return 'true'

    def get_json(self):

        response = urllib3.urlopen(self.url)
        data = json.load(response)

        today = datetime.date.today()

        return {
            'guid': self.uuid,
            'isActive': data[0]['isActive'],
            'pressure': data[0]['pressure'],
            'pressure_t': data[0]['pressure_t'],
            'humidity': data[0]['humidity'],
            'humidity_t': data[0]['humidity_t'],
            'objtemp': data[0]['objtemp'],
            'accelX': data[0]['accelX'],
            'accelY': data[0]['accelY'],
            'accelZ': data[0]['accelZ'],
            'gyroX': data[0]['gyroX'],
            'gyroY': data[0]['gyroY'],
            'gyroZ': data[0]['gyroZ'],
            'magX': data[0]['magX'],
            'magY': data[0]['magY'],
            'magZ': data[0]['magZ'],
            'light': data[0]['light'],
            'battery': data[0]['battery'],
            'key1': data[0]['key1'],
            'key2': data[0]['key2'],
            'reed': data[0]['reed'],
            'buzzer': data[0]['buzzer'],
            'LED1': data[0]['LED1'],
            'LED2': data[0]['LED2'],
            'Radio': data[0]['Radio'],
            'date': today.ctime()
        }
