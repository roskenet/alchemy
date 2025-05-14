cmake_minimum_required(VERSION 3.18)
project(myexec C)

set(CMAKE_C_STANDARD 11)

add_executable(myexec main.c mykillerfunc.c)
