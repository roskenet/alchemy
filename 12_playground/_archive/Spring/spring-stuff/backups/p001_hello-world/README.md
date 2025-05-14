# Hello World

## Java
See HelloWorld.java. Java requires that the file is called as the puplic defined class in it. 

Compile it with `javac HelloWorld.java`

Run it with `java HelloWorld`

## Kotlin
# compile Kotlin to .jar
kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar

# run Kotlin .jar
kotlin -classpath HelloWorld.jar HelloWorldKt