################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../CuppaClock.cpp \
../cuppa3.cpp 

LINK_OBJ += \
./CuppaClock.cpp.o \
./cuppa3.cpp.o 

CPP_DEPS += \
./CuppaClock.cpp.d \
./cuppa3.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
CuppaClock.cpp.o: ../CuppaClock.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

cuppa3.cpp.o: ../cuppa3.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -Wno-error=narrowing -MMD -flto -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10812 -DARDUINO_AVR_NANO -DARDUINO_ARCH_AVR   -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/variants/eightanaloginputs" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/cores/arduino" -I"/home/felix/Packages/arduino/libraries/Adafruit-GFX-Library" -I"/home/felix/Packages/arduino/libraries/Adafruit_SSD1306" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/Wire/src" -I"/home/felix/Packages/arduino/libraries/Adafruit_BusIO" -I"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/hardware/avr/1.8.6/libraries/SPI/src" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '


