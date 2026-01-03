################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_GFX.cpp \
/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_GrayOLED.cpp \
/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_SPITFT.cpp 

C_SRCS += \
/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/glcdfont.c 

C_DEPS += \
./libraries/Adafruit-GFX-Library/glcdfont.c.d 

LINK_OBJ += \
./libraries/Adafruit-GFX-Library/Adafruit_GFX.cpp.o \
./libraries/Adafruit-GFX-Library/Adafruit_GrayOLED.cpp.o \
./libraries/Adafruit-GFX-Library/Adafruit_SPITFT.cpp.o \
./libraries/Adafruit-GFX-Library/glcdfont.c.o 

CPP_DEPS += \
./libraries/Adafruit-GFX-Library/Adafruit_GFX.cpp.d \
./libraries/Adafruit-GFX-Library/Adafruit_GrayOLED.cpp.d \
./libraries/Adafruit-GFX-Library/Adafruit_SPITFT.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
libraries/Adafruit-GFX-Library/Adafruit_GFX.cpp.o: /home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_GFX.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

libraries/Adafruit-GFX-Library/Adafruit_GrayOLED.cpp.o: /home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_GrayOLED.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

libraries/Adafruit-GFX-Library/Adafruit_SPITFT.cpp.o: /home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/Adafruit_SPITFT.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

libraries/Adafruit-GFX-Library/glcdfont.c.o: /home/felix/Packages/arduino/libraries/Adafruit-GFX-Library/glcdfont.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '


