################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/HardwareSerial.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Print.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Stream.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/TinySoftwareSerial.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Tone.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WMath.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WString.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/abi.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/main.cpp \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/new.cpp 

S_UPPER_SRCS += \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_pulse.S 

C_SRCS += \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WInterrupts.c \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring.c \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_analog.c \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_digital.c \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_pulse.c \
/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_shift.c 

C_DEPS += \
./core/core/WInterrupts.c.d \
./core/core/wiring.c.d \
./core/core/wiring_analog.c.d \
./core/core/wiring_digital.c.d \
./core/core/wiring_pulse.c.d \
./core/core/wiring_shift.c.d 

AR_OBJ += \
./core/core/HardwareSerial.cpp.o \
./core/core/Print.cpp.o \
./core/core/Stream.cpp.o \
./core/core/TinySoftwareSerial.cpp.o \
./core/core/Tone.cpp.o \
./core/core/WInterrupts.c.o \
./core/core/WMath.cpp.o \
./core/core/WString.cpp.o \
./core/core/abi.cpp.o \
./core/core/main.cpp.o \
./core/core/new.cpp.o \
./core/core/wiring.c.o \
./core/core/wiring_analog.c.o \
./core/core/wiring_digital.c.o \
./core/core/wiring_pulse.S.o \
./core/core/wiring_pulse.c.o \
./core/core/wiring_shift.c.o 

S_UPPER_DEPS += \
./core/core/wiring_pulse.S.d 

CPP_DEPS += \
./core/core/HardwareSerial.cpp.d \
./core/core/Print.cpp.d \
./core/core/Stream.cpp.d \
./core/core/TinySoftwareSerial.cpp.d \
./core/core/Tone.cpp.d \
./core/core/WMath.cpp.d \
./core/core/WString.cpp.d \
./core/core/abi.cpp.d \
./core/core/main.cpp.d \
./core/core/new.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
core/core/HardwareSerial.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/HardwareSerial.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/Print.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Print.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/Stream.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Stream.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/TinySoftwareSerial.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/TinySoftwareSerial.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/Tone.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/Tone.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/WInterrupts.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WInterrupts.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/WMath.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WMath.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/WString.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/WString.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/abi.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/abi.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/main.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/main.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/new.cpp.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/new.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/bin/avr-g++" -c -g -Os -w -std=gnu++11 -fpermissive -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring_analog.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_analog.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring_digital.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_digital.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring_pulse.S.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_pulse.S
	@echo 'Building file: $<'
	@echo 'Starting S compile'
	"/bin/avr-gcc" -c -g -x assembler-with-cpp -flto -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring_pulse.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_pulse.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '

core/core/wiring_shift.c.o: /home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny/wiring_shift.c
	@echo 'Building file: $<'
	@echo 'Starting C compile'
	"/bin/avr-gcc" -c -g -Os -w -std=gnu11 -ffunction-sections -fdata-sections -MMD -flto -fno-fat-lto-objects -mmcu=attiny461 -DF_CPU=1000000L -DCLOCK_SOURCE=0 -DARDUINO=10812 -DARDUINO_AVR_ATTINYX61 -DARDUINO_ARCH_AVR  -DDISABLEMILLIS  -DNEOPIXELPORT=PORTA -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/cores/tiny" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/variants/tinyX61" -I"/home/felix/Workspaces/Forks/ATTinyCore/avr/libraries/SPI" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 "$<" -o "$@"
	@echo 'Finished building: $<'
	@echo ' '


