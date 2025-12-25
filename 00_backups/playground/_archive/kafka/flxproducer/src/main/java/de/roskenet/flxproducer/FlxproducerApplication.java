package de.roskenet.flxproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

@SpringBootApplication
public class FlxproducerApplication implements CommandLineRunner {

    static class MyObject implements Sendable {

        public String name;
        public LocalDate birthday;

        @Override
        public String serialised() {
            return(String.format(
                    """
                        {"name": "%s",
                         "birthday": "%s"}
                    """, name, birthday.format(DateTimeFormatter.ISO_DATE)
            ));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(FlxproducerApplication.class, args);

        var myObject = new MyObject();
        myObject.name = "Anna Konda";
        myObject.birthday = LocalDate.of(1974, 8, 22);

        FlxKafkaClient.syncronousSend(myObject);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");


    }

}
