cmake_minimum_required(VERSION 3.23)
project(TempDemo LANGUAGES C CXX ASM)

include(cmake/lto.cmake)
include(cmake/arduino_core.cmake)
include(cmake/arduino_hex.cmake)
include(cmake/arduino_upload.cmake)

add_executable(TempDemo temp.cpp
        DHT.cpp)

#add_library(Wire STATIC
#        ~/Packages/arduino/Wire/src/Wire.cpp
#        ~/Packages/arduino/Wire/src/WireS.cpp
#        ~/Packages/arduino/Wire/src/twi.c
#)

target_link_libraries(TempDemo PUBLIC ArduinoCore)

target_compile_options(TempDemo PRIVATE
    "-Wall"
    "-Wextra"
    "-pedantic"
)

arduino_avr_hex(TempDemo)
arduino_avr_upload(TempDemo ${ARDUINO_PORT})
