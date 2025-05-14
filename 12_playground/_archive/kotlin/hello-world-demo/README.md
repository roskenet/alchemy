# Five Ways to say Hello Kotlin

## Use the Kotlin Playground

Point your browser to https://play.kotlinlang.org.

## Use the REPL

```shell
❯ kotlin
Welcome to Kotlin version 1.9.10 (JRE 21+35)
Type :help for help, :quit for quit
>>> println("Hello World!")
Hello World!
>>> :quit
```

## Run Kotlin as Script

```shell
kotlin HelloWorld.kts
```

## Compile to Java Bytecode

```shell
kotlinc HelloWorld.kt

kotlin HelloWorldkt
```

## Compile a Runnable Jar

```shell
kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar

java -jar HelloWorld.jar
```

