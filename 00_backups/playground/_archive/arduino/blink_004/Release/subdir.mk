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
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=8000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR    -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61_New" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"

	@echo 'Finished building: $<'
	@echo ' '


