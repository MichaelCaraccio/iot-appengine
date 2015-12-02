import random
import json
import datetime

class Sensor_tag:
    def __init__(self,name,uuid,radio):
        self.name = name
        self.uuid = uuid
        self.radio = radio
        self.init_sensor()

    def init_sensor(self):
        self.pressure = random.randrange(0, 101, 2)
        self.pressure_t = random.randrange(0, 101, 2)
        self.humidity = random.randrange(0, 101, 2)
        self.humidity_t = random.randrange(0, 101, 2)
        self.objtemp = random.randrange(0, 101, 2)
        self.accel_x = random.randrange(0, 101, 2)
        self.accel_y = random.randrange(0, 101, 2)
        self.accel_z = random.randrange(0, 101, 2)
        self.gyro_x = random.randrange(0, 101, 2)
        self.gyro_y = random.randrange(0, 101, 2)
        self.gyro_z = random.randrange(0, 101, 2)
        self.mag_x = random.randrange(0, 101, 2)
        self.mag_y = random.randrange(0, 101, 2)
        self.mag_z = random.randrange(0, 101, 2)
        self.light = random.randrange(0, 101, 2)
        self.battery = random.randrange(0, 101, 2)
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

    def new_value(self):
        way = random.randint(0,1)
        if way == 0:
            val = random.randint(0,5)
        else:
            val = -random.randint(0,5)
        return val

    def incr_pressure(self):
        self.pressure += self.new_value()

    def incr_pressure_t(self):
        self.pressure_t += self.new_value()

    def incr_humidity(self):
        self.humidity += self.new_value()

    def incr_humidity_t(self):
        self.humidity_t += self.new_value()

    def incr_accel_x(self):
        self.accel_x += self.new_value()

    def incr_accel_y(self):
        self.accel_y += self.new_value()

    def incr_accel_z(self):
        self.accel_z += self.new_value()

    def incr_gyro_x(self):
        self.gyro_x += self.new_value()

    def incr_gyro_y(self):
        self.gyro_y += self.new_value()

    def incr_gyro_z(self):
        self.gyro_z += self.new_value()

    def incr_mag_x(self):
        self.mag_x += self.new_value()

    def incr_mag_y(self):
        self.mag_y += self.new_value()

    def incr_mag_z(self):
        self.mag_z += self.new_value()

    def incr_light(self):
        self.light += self.new_value()

    def incr_all(self):
        self.incr_pressure()
        self.incr_pressure_t()
        self.incr_humidity()
        self.incr_humidity_t()
        self.incr_accel_x()
        self.incr_accel_y()
        self.incr_accel_z()
        self.incr_gyro_x()
        self.incr_gyro_y()
        self.incr_gyro_z()
        self.incr_mag_x()
        self.incr_mag_y()
        self.incr_mag_z()
        self.incr_light()

    def get_json(self):
        self.incr_all()
        today = datetime.date.today()

        return json.dumps({'measures' : [
            {
                'guid': self.uuid,
                'isActive': self.get_is_activated(),
                'pressure': self.pressure,
                'pressure_t': self.pressure_t,
                'humidity': self.humidity,
                'humidity_t': self.humidity_t,
                'objtemp': 718.29,
                'accelX': self.accel_x,
                'accelY': self.accel_y,
                'accelZ': self.accel_z,
                'gyroX': self.gyro_x,
                'gyroY': self.gyro_y,
                'gyroZ': self.gyro_z,
                'magX': self.mag_x,
                'magY': self.mag_y,
                'magZ': self.mag_z,
                'light': self.light,
                'battery': self.battery,
                'key1': self.key1,
                'key2': self.key2,
                'reed': self.reed,
                'buzzer': self.buzzer,
                'LED1': self.led_1,
                'LED2': self.led_2,
                'Radio': self.radio,
                'date': today.ctime()
            }
        ]})