cmake_minimum_required(VERSION 3.22)
project(hellocpp)

set(CMAKE_CXX_STANDARD 14)

add_executable(hellocpp main.cpp killerapp/myfunction.h killerapp/myfunction.cpp)
