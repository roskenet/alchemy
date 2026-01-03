package applications.example_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example_Basics implements CommandLineRunner {

    @Autowired
    private ArtistRepository artistRepository;

    public static void main(String[] args) {
        SpringApplication.run(Example_Basics.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Saving Amy:");
//        saveAmy();

        updateAnExistingAmy();
//        System.out.println("Saving Amy a second time:");
//        saveAmy();
    }

    private void updateAnExistingAmy() {
        var existingAmy = new Artist();
        existingAmy.setId(5);
        existingAmy.setName("Amy The Greatest");

        artistRepository.save(existingAmy);
    }

    private void saveAmy() {
        var amy = new Artist();
        amy.setName("Amy Winehouse");
        var savedAmy = artistRepository.save(amy);

        artistRepository.save(savedAmy);
    }
}
