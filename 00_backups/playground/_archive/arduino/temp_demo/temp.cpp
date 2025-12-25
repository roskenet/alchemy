#include <avr/io.h>
#include <util/delay.h>
#include <HardwareSerial.h>

#include "DHT.h"

#define DHTPIN 2
#define DHTTYPE 22   // DHT 22  (AM2302), AM2321

DHT dht(DHTPIN, DHTTYPE);

int main(void) {

  Serial.begin(9600);
  Serial.println(F("DHTxx test!"));
  dht.begin();

  Serial.println("After begin");
    while (1) {
        _delay_ms( 2000);
        //Zwei Sekunden bis zur Messung warten damit der Sensor etwas //messen kann weil er relativ langsam ist

        Serial.println("lese humidity");
  // Reading temperature or humidity takes about 250 milliseconds!
  // Sensor readings may also be up to 2 seconds 'old' (its a very slow sensor)
  float h = dht.readHumidity();
  // Read temperature as Celsius (the default)
        Serial.println("lese temp");
  float t = dht.readTemperature();
  // Read temperature as Fahrenheit (isFahrenheit = true)
  Serial.println("lese als F");
  float f = dht.readTemperature(true);

  // Check if any reads failed and exit early (to try again).
  if (isnan(h) || isnan(t) || isnan(f)) {
    Serial.println(F("Failed to read from DHT sensor!"));
//    return;
  }

  // Compute heat index in Fahrenheit (the default)
  float hif = dht.computeHeatIndex(f, h);
  // Compute heat index in Celsius (isFahreheit = false)
  float hic = dht.computeHeatIndex(t, h, false);

  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print(F("%  Temperature: "));
  Serial.print(t);
  Serial.print(F("°C "));
  Serial.print(f);
  Serial.print(F("°F  Heat index: "));
  Serial.print(hic);
  Serial.print(F("°C "));
  Serial.print(hif);
  Serial.println(F("°F"));
    }
    return 0;
}