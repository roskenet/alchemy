set(CMAKE_TOOLCHAIN_FILE cmake/ArduinoToolchain.cmake)

cmake_minimum_required(VERSION 3.5)

project(Project_Name C CXX)

set(ARDUINO_DEFAULT_BOARD uno) # Default Board ID
set(ARDUINO_DEFAULT_PORT /dev/ttyACM0) # Default Port

generate_arduino_firmware(exe_name SRCS main.c)
