cmake_minimum_required(VERSION 3.20)

project(
    "hello"
    VERSION 1.0
    DESCRIPTION "Hello World using CMake"
    LANGUAGES CXX)

add_executable(hello)

target_sources(hello PRIVATE src/main.cpp)

#set(MY_VARIABLE "Hello World!")

message("This is a message! ${MY_VARIABLE}")
