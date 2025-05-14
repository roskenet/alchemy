# My attiny461 direct flash experiments

# This works on the command line:

```shell
avr-gcc -Os -Wall -std=gnu99 -mmcu=attiny461 -D F_CPU=1000000 hello.c -o hello.elf
```

```shell
avr-objcopy -O ihex -R .eeprom hello.elf hello.hex                                

```

```shell
/bin/avrdude -pattiny461 -cstk500v2 -P/dev/ttyACM0 -b9600 -Uflash:w:hello.hex:i 

```

Check for compiler options and optimizations... Others did:

avr-gcc -mmcu=atmega128 -I. -gstabs -Os -Wall -Wstrict-prototypes -std=gnu99 filename.o --output filename.elf -lm

avr-gcc -mmcu=atmega32 -I. -gdwarf-2   -Os -funsigned-char 
-funsigned-bitfields -fpack-struct -fshort-enums -Wall 
-Wstrict-prototypes -Wa,-adhlns=main.o  -std=gnu99 -DF_OSC=20000000 -MD 
-MP -MF .dep/test.elf.d main.o   --output test.elf 
-Wl,-Map=main.map,--cref    -lm


Sloeber-IDE uses the following compiler flags:
"/bin/avr-g++" -c -g -Os -w 
-std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto 
-mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 
-DARDUINO_ARCH_AVR    
-DNEOPIXELPORT=PORTA 
-I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" 
-I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" 
-I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" 
-MMD -MP -MF"sloeber.ino.cpp.d" -MT"sloeber.ino.cpp.o" 
-D__IN_ECLIPSE__=1 "../sloeber.ino.cpp" -o "sloeber.ino.cpp.o"

