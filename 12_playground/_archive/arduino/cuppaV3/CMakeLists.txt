cmake_minimum_required(VERSION 3.23)
project(Blink LANGUAGES C CXX ASM)

include(cmake/lto.cmake)
include(cmake/arduino_core.cmake)
include(cmake/arduino_hex.cmake)
include(cmake/arduino_upload.cmake)

add_library(ssd1306 STATIC Adafruit_SSD1306/Adafruit_SSD1306.cpp)
add_library(wire STATIC Wire/src/Wire.cpp)
add_library(gfx STATIC Adafruit-GFX-Library/Adafruit_GFX.cpp)
add_library(spi STATIC SPI/SPI.cpp)

add_executable(project blink.cpp)

target_link_libraries(project PUBLIC ArduinoCore)

target_compile_options(project PRIVATE
    "-Wall"
    "-Wextra"
    "-pedantic"
)
arduino_avr_hex(project)
arduino_avr_upload(project ${ARDUINO_PORT})
