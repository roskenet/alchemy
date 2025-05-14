cmake_minimum_required(VERSION 3.23)
project(Blink LANGUAGES C CXX ASM)

include(cmake/lto.cmake)
include(cmake/arduino_core.cmake)
include(cmake/arduino_hex.cmake)
include(cmake/arduino_upload.cmake)

add_executable(Blink blink.cpp)

target_link_libraries(Blink PUBLIC ArduinoCore)

target_compile_options(Blink PRIVATE
    "-Wall"
    "-Wextra"
    "-pedantic"
)
arduino_avr_hex(Blink)
arduino_avr_upload(Blink ${ARDUINO_PORT})
