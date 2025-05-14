#include <Arduino.h>

void setup() {
    Serial.begin(115200);
    delay(2000);
    Serial.println("Hello, world!");
    pinMode(13, OUTPUT);
}

void loop() {
    digitalWrite(13, HIGH);
    delay(50);
    digitalWrite(13, LOW);
    delay(950);
}
