/*
  Showing number 0-9 on a Common Anode 7-segment LED display
  Displays the numbers 0-9 on the display, with one second inbetween.
    A
   ---
F |   | B
  | G |
   ---
E |   | C
  |   |
   ---
    D
  This example code is in the public domain.
 */

// Pin 2-8 is connected to the 7 segments of the display.

#include "SevSeg.h"
SevSeg sevseg;

void setup(){
  byte numDigits = 4;
  byte digitPins[] = {10, 11, 12, 13};
  byte segmentPins[] = {9, 2, 3, 5, 6, 8, 7, 4};

  bool resistorsOnSegments = true;
  bool updateWithDelaysIn = false;
  byte hardwareConfig = COMMON_CATHODE;
  sevseg.begin(hardwareConfig, numDigits, digitPins, segmentPins, resistorsOnSegments, updateWithDelaysIn);
  sevseg.setBrightness(90);
}

void loop(){

	int x = 2500;

	while (x > 0) {
		sevseg.setNumber(x, 1);
		sevseg.refreshDisplay();
		x = x-1;
		delay(100);
	}

}
