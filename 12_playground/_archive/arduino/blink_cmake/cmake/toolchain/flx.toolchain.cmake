# Enter CMake cross-compilation mode
set(CMAKE_SYSTEM_NAME Generic)
set(CMAKE_SYSTEM_PROCESSOR avr)

set(ARDUINO_PATH "$ENV{HOME}/Packages/avr8-gnu-toolchain-linux_x86_64" CACHE PATH
    "Path of the Arduino packages folder, e.g. ~/.arduino15/packages/arduino.")
set(ARDUINO_TOOLS_PATH ${ARDUINO_PATH}/bin)

set(AVR_CORE_PATH "/home/felix/Packages/ATTinyCore")
set(ARDUINO_AVR_PATH "${AVR_CORE_PATH}/avr")

set(ARDUINO_CORE_PATH "${AVR_CORE_PATH}/avr/cores/tiny")

set(ARDUINO_VARIANT "tinyX61")
set(ARDUINO_MCU "attiny461")
set(ARDUINO_F_CPU "1000000")
set(ARDUINO_PORT "/dev/ttyACM0")
set(ARDUINO_AVRDUDE_SPEED "9600")
set(ARDUINO_AVRDUDE_PROTOCOL "stk500v2")

set(ARDUINO_AVRDUDE_PATH /usr)
set(ARDUINO_AVRDUDE_CONF /etc/avrdude.conf)

# Toolchain paths
set(CMAKE_C_COMPILER ${ARDUINO_TOOLS_PATH}/avr-gcc CACHE FILEPATH
    "Path to avr-gcc" FORCE)
set(CMAKE_CXX_COMPILER ${ARDUINO_TOOLS_PATH}/avr-g++ CACHE FILEPATH
    "Path to avr-g++" FORCE)
set(CMAKE_OBJCOPY ${ARDUINO_TOOLS_PATH}/avr-objcopy CACHE FILEPATH
    "Path to avr-objcopy" FORCE)
set(CMAKE_SIZE ${ARDUINO_TOOLS_PATH}/avr-size CACHE FILEPATH
    "Path to avr-size" FORCE)
set(ARDUINO_AVRDUDE ${ARDUINO_AVRDUDE_PATH}/bin/avrdude CACHE FILEPATH
    "Path to avrdude" FORCE)

# Only look libraries etc. in the sysroot, but never look there for programs
set(CMAKE_FIND_ROOT_PATH_MODE_PROGRAM NEVER)
set(CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY)
set(CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY)
set(CMAKE_FIND_ROOT_PATH_MODE_PACKAGE ONLY)
