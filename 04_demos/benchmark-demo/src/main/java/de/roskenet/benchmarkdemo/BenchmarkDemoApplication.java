package de.roskenet.benchmarkdemo;

import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class BenchmarkDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BenchmarkDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Benchmark
    public void doSomething(int counter) {
        var reduce = IntStream.range(0, counter)
                .reduce(0, Integer::sum);
        System.out.println("The result is: " + reduce);
    }
}
