package poc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private JsonvalsRepository repository;

    @Override
    public void run(String... args) {
        System.out.println("Hello World!");

        saveCoolValue();

        var all = repository.findAll();
        all.forEach(jsonvals -> readCoolValue(jsonvals.getItem()));

    }

    private void readCoolValue(String someJsonVal) {
        var om = new ObjectMapper();

        MyStringProperty myStringProperty;
        try {
            myStringProperty = om.readValue(someJsonVal, MyStringProperty.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myStringProperty);
    }

    private void saveCoolValue() {
        var jsonvals = new Jsonvals();
        jsonvals.setItem("{ \"value\": \"cool value\" }");
        jsonvals.setStatus(Status.ACTIVE);
        repository.save(jsonvals);
    }
}
