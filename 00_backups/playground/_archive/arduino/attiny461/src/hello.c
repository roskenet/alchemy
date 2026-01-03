#include<avr/io.h>
#include<avr/interrupt.h>
#include<util/delay.h>

void buttonInterrupt(void);

volatile uint8_t my_flag = 0;

ISR(PCINT_vect) {
    // Does this debpunce?
    if (~(PINA) & (1 << PINA4)) {
        _delay_ms(50);
        if (~(PINA) & (1 << PINA4)) {
           buttonInterrupt();
        }
    }
}

void buttonInterrupt(void) {
    if (~(PINA) & (1 << PINA4)) {
        my_flag = 1;
    }
}

int main(void) {
    DDRB |= (1 << 5);
    DDRA = 0b00000000;

    PORTA |= 0xFF;

    GIMSK |= (1 << 5);
//    PCMSK0 = 0b00010000;  // Pin-change interrupt for PB0, PB1, PB2
    PCMSK0 |= (1 << 4);
    sei();

    while (1) {
//        if (~(PINA) & (1 << PINA4)) {
//            PORTB = 0b00100000;
//            _delay_ms(1000);
//        }
        if (my_flag == 1) {
            for (int i = 0; i < 10; ++i) {
                PORTB = 0b00100000;
                _delay_ms(50);
                PORTB = 0b00000000;
                _delay_ms(250);
            }
        } else {
//            PORTB = 0b00100000;
//            _delay_ms(1000);

            PORTB = 0b00000000;
//            _delay_ms(100);
//        }
        }
        my_flag = 0;
    }
    return 0;
}
