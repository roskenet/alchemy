################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../sloeber.ino.cpp 

LINK_OBJ += \
./sloeber.ino.cpp.o 

CPP_DEPS += \
./sloeber.ino.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
sloeber.ino.cpp.o: ../sloeber.ino.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/felix/Packages/Sloeber/arduinoPlugin/packages/arduino/tools/avr-gcc/7.3.0-atmel3.6.1-arduino7/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny85 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX5 -DARDUINO_ARCH_AVR   -DNEOPIXELPORT=PORTB    -I"/home/felix/Packages/Sloeber/arduinoPlugin/examples/01.Basics/Blink" -I"/home/felix/Workspaces/Arduino/hardware/ATTinyCore-1.5.2/avr/cores/tiny" -I"/home/felix/Workspaces/Arduino/hardware/ATTinyCore-1.5.2/avr/variants/tinyX5" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"   -o "$@"

	@echo 'Finished building: $<'
	@echo ' '


