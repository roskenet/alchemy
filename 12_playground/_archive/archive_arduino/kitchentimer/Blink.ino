//definieren der angeschlossenen kapazitiven Touch Sensoren
#define cap_touch_sensor_1 12
//definieren der LEDs
#define led_1 13
//Variablen für den Status der LEDs
int led_state_1 = LOW;

void setup() {
  pinMode(cap_touch_sensor_1, INPUT);
  pinMode(led_1, OUTPUT);

  digitalWrite(led_1, led_state_1);
}

void loop() {
  led_state_1 = checkSensor(cap_touch_sensor_1);
  digitalWrite(led_1, led_state_1);
}

int checkSensor(int sensor) {

	int state = led_state_1;

	  if (digitalRead(sensor == HIGH)) {
	      int new_state = led_state_1^digitalRead(cap_touch_sensor_1);

	      if (new_state != state) {
	    	 state = new_state;
	    	 delay(200);
	      }

	  }

	  return state;
}
