# Cmake chain:

Forks/Arduino-AVR-CMake

make upload-blink


```
cmake -S. -Bbuild \        
          -D ARDUINO_PORT=/dev/ttyACM0 \
          -D CMAKE_TOOLCHAIN_FILE=cmake/toolchain/uno.toolchain.cmake \
          -D CMAKE_BUILD_TYPE=MinSizeRel
```
