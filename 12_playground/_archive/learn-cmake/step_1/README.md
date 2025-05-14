# Stages of CMake build

1. cmake -B build
2. cmake --build build


cmake -S . -B build -D CMAKE_BUILD_TYPE=Release
(Is one of Debug, Release, MinSizeRel, or RelWithDebInfo)

cmake --list-presets

cmake -E echo "Hello World!"
