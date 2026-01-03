#include "Arduino.h"

#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128 // OLED display width, in pixels
#define SCREEN_HEIGHT 64 // OLED display height, in pixels
#define OLED_RESET     -1 // Reset pin # (or -1 if sharing Arduino reset pin)
#define SCREEN_ADDRESS 0x3C ///< See datasheet for Address; 0x3D for 128x64, 0x3C for 128x32

const uint8_t modePin = 2;
const uint8_t decPin = 3;
const uint8_t incPin = 4;

Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);
char *time = (char*) malloc(5 * sizeof(char));
uint8_t min = 2;
uint8_t sec = 30;
bool visible = true;

void printText(unsigned int, unsigned int);
void printText(char*);

void setup() {
    pinMode(modePin, INPUT);
    pinMode(decPin, INPUT);
    pinMode(incPin, INPUT);

    if (!display.begin(SSD1306_SWITCHCAPVCC, SCREEN_ADDRESS)) {
        for (;;)
            ; // Don't proceed, loop forever
    }
}

uint8_t modeState = LOW;
uint8_t incState = LOW;
uint8_t decState = LOW;

uint8_t displayMode = 0;

void loop() {
    modeState = digitalRead(modePin);
    incState = digitalRead(incPin);
    decState = digitalRead(decPin);

    if (modeState == HIGH) {
        displayMode = 1;
    }
//	if (incState == HIGH) {
//		displayMode = 2;
//	}
//	if (decState == HIGH) {
//		displayMode = 3;
//	}

    if (displayMode == 0) {
        if (min == 0 && sec == 0) {
            printText("00:00");
        } else {
            printText(min, sec);
            if (sec == 0) {
                min--;
                sec = 59;
            } else {
                sec--;
            }
        }
    }
    delay(1000);
}

void printText(char *text) {
    if (visible) {
        display.clearDisplay();
        display.setTextColor(SSD1306_WHITE);
        display.setTextSize(4);
        display.setCursor(1, 1);
        display.println(text);
        display.display();
        visible = false;
    } else {
        display.clearDisplay();
        display.display();
        visible = true;
    }
}

void printText(unsigned int min, unsigned int sec) {
    sprintf(time, "%02d:%02d", min, sec);

    display.clearDisplay();
    display.setTextColor(SSD1306_WHITE);
    display.setTextSize(4);
    display.setCursor(1, 1);
    display.println(time);
    display.display();
}
