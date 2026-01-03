cmake_minimum_required(VERSION 3.23)
project(Blink LANGUAGES C CXX ASM)

include(cmake/lto.cmake)
include(cmake/arduino_core.cmake)
include(cmake/arduino_hex.cmake)
include(cmake/arduino_upload.cmake)

add_executable(project blink.c)

target_link_libraries(project PUBLIC ArduinoCore)

target_compile_options(project PRIVATE
    "-Wall"
    "-Wextra"
    "-pedantic"
)
arduino_avr_hex(project)
arduino_avr_upload(project ${ARDUINO_PORT})
