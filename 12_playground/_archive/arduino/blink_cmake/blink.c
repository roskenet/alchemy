#include<avr/io.h>
#include<util/delay.h>
#include<avr/interrupt.h>

volatile uint8_t myFlag = 0;

ISR(PCINT_vect) {
    if(~PORTB & 00100000) {
        if (myFlag == 0) {
            myFlag = 1;
        } else {
            myFlag = 0;
        }
    }
}

void initInterrupt() {
    GIMSK |= (1 << PCIE1);
    PCMSK0 |= (1 << 4);
}

int main(void) {
    // PINOUT:
    DDRB |= (1 << 5);

//    PORTA |= (1 << 5);
//    PORTB |= (1 << 4);

    initInterrupt();

    sei();

    while (1) {
        if (myFlag == 0) {
            PORTB = 0b00100000;
            _delay_ms(100);
            PORTB = 0b00000000;
            _delay_ms(100);
        } else {
            PORTB = 0b00100000;
            _delay_ms(1000);
            PORTB = 0b00000000;
            _delay_ms(100);
        }
    }

    return 0;
}






//void setup() {
//    Serial.begin(115200);
//    delay(2000);
//    Serial.println("Hello, world!");
//    pinMode(PA4, OUTPUT);
//}
//
//void loop() {
//    digitalWrite(PA4 , HIGH);
//    delay(500);
//    digitalWrite(PA4, LOW);
//    delay(500);
//    Serial.println("Hello, world!");
//}
