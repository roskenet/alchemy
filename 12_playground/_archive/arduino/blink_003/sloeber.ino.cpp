#ifdef __IN_ECLIPSE__
//This is a automatic generated file
//Please do not modify this file
//If you touch this file your change will be overwritten during the next build
//This file has been generated on 2024-03-21 01:52:00

#include "Arduino.h"
#include "Arduino.h"
#define PROG_FLICKER true
#define SPI_CLOCK 		(1000000/6)
#define USE_HARDWARE_SPI
#define RESET     10
#define LED_HB    9
#define LED_ERR   8
#define LED_PMODE 7
#define PIN_MOSI 	MOSI
#define PIN_MISO 	MISO
#define PIN_SCK 	SCK
#define SERIAL Serial
#define BAUDRATE	19200
#define HWVER 2
#define SWMAJ 1
#define SWMIN 18
#define STK_OK      0x10
#define STK_FAILED  0x11
#define STK_UNKNOWN 0x12
#define STK_INSYNC  0x14
#define STK_NOSYNC  0x15
#define CRC_EOP     0x20
#include "SPI.h"

void setup() ;
void heartbeat() ;
void reset_target(bool reset) ;
void loop(void) ;
uint8_t getch() ;
void fill(int n) ;
void pulse(int pin, int times) ;
void prog_lamp(int state) ;
uint8_t spi_transaction(uint8_t a, uint8_t b, uint8_t c, uint8_t d) ;
void empty_reply() ;
void breply(uint8_t b) ;
void get_version(uint8_t c) ;
void set_parameters() ;
void start_pmode() ;
void end_pmode() ;
void universal() ;
void flash(uint8_t hilo, unsigned int addr, uint8_t data) ;
void commit(unsigned int addr) ;
unsigned int current_page() ;
void write_flash(int length) ;
uint8_t write_flash_pages(int length) ;
uint8_t write_eeprom(unsigned int length) ;
uint8_t write_eeprom_chunk(unsigned int start, unsigned int length) ;
void program_page() ;
uint8_t flash_read(uint8_t hilo, unsigned int addr) ;
char flash_read_page(int length) ;
char eeprom_read_page(int length) ;
void read_page() ;
void read_signature() ;
void avrisp() ;


#include "ArduinoISP.ino"

#endif
