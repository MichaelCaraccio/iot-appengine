from flask import Flask
import urllib.request

# Initialize the Flask application
app = Flask(__name__)


# Define a basic root route, will only accept GET requests as
# that's the default behaviour for the moment. We'll use the
# route decorator, and define the view function that will be
# executed when the current route is matched/requested
@app.route('/')
def hello():
    # This would print Hello World
    with urllib.request.urlopen('http://python.org/') as response:
        html = response.read()
    return html


# Define a route accepting POST and GET requests capturing
# a variable part, a name in this case, wrapping it between <>
# The variable needs to be passed to the view function as 
# a keyword argument
@app.route('/getdata', methods=['GET', 'POST'])
def hello_name():
    # If the user browsed /hello/John, the output would be
    # "Hello John!"
    return 'GetData called'


# An extra twist to the previous case, the variable part needs
# to be a given data type, integer in this case. We need to
# wrap between <> the type (int) and name of the variable (number)
@app.route('/getsensorslist')
def random_number():
    # If the user browsed /hello/John, the output would be
    # "Hello John!"
    # TODO get list from z1
    return 'GetSensorsList called'


if __name__ == '__main__':

    # Get list of sensors from Z1
    app.run(
        host="0.0.0.0",
        port=int("80")
    )
