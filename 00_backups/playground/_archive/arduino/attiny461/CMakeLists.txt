cmake_minimum_required(VERSION 3.20)

project(
    "hello"
    VERSION 1.0
    DESCRIPTION "Hello ATtiny461"
    LANGUAGES C CXX)

set(CMAKE_C_FLAGS_DEBUG "-g -O0 -Wall -fshort-enums -funsigned-bitfields -funsigned-char -fpack-struct -std=gnu99 -mmcu=attiny461 -D F_CPU=1000000")
set(CMAKE_C_FLAGS_RELEASE "-O2 -Wall -fshort-enums -funsigned-bitfields -funsigned-char -fpack-struct -std=gnu99 -mmcu=attiny461 -D F_CPU=1000000")
#set(CMAKE_C_FLAGS_MINSIZEREL "put your flags")
#set(CMAKE_C_FLAGS_RELWITHDEBINFO "put your flags")

add_executable(hello)

target_sources(hello PRIVATE src/hello.c)
