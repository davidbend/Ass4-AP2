# FlightGear Controller
Android application for FlightGear simulator, as part of an Advanced Programming course.
In this application, we'll connect to the simulator server and launch the plane with a joystick.

## Activites
#### Login
This window will contain two fields for entering an IP address and PORT as well as a connection button to the simulator server.

#### Joystick
In this window, we will show the Joystick user that will allow the user to modify the aileron values and the elevator values.
The joystick will send commands to Flight Simulator (SET commands) via TCP / IP communication when the application will be the client
and the simulator will be the server.

## Running the tests
You will find a server code in a file called 'Server.cs' that simulates the Flight Simulator, and for each command received from the client,
it displays on the screen.

#### Instructions
Run the server code, then launch the application and follow these steps:

In the login activity, enter the following details:
##### IP:
```
10.0.2.2
```
##### Port:
```
5402
```
Press 'Connect'.

Now, the commands received from the joystick will be printed in the program of the server.
