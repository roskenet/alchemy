package applications.example_C;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleC implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExampleC.class, args);
    }

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        persistMichaelJackson();

        addAlbumBadToMichael();
//        addAlbumThrillerToMichael();
//        addAlbumJamToMichael();

    }

    private void addAlbumBadToMichael() {
        var michael = artistRepository.findByName("Michael Jackson");
        var bad = new Album();
        bad.setName("Bad");

        // This is both needed to have the link between the two:
        // consider a convenience method in Artist that adds himself to the album
        bad.setArtist(michael);
        michael.getAlbums().add(bad);

        var save = artistRepository.save(michael);
    }

    private void addAlbumJamToMichael() {
        var michael = artistRepository.findByName("Michael Jackson");

        michael.getAlbums().forEach(System.out::println);

        var jam = new Album();
        jam.setName("Jam");
        jam.setArtist(michael);

        michael.getAlbums().add(jam);
        artistRepository.save(michael);
    }

    private void addAlbumThrillerToMichael() {
        var blink182 = artistRepository.findByName("Blink-182");
        var michaelJackson = artistRepository.findByName("Michael Jackson");

        var thriller = new Album();
        thriller.setName("Thriller");
        thriller.setArtist(michaelJackson);

        michaelJackson.getAlbums().add(thriller);

        artistRepository.save(michaelJackson);
    }

    private void persistMichaelJackson() {
        var michael = artistRepository.findByName("Michael Jackson");
        if (michael == null) {
            michael = new Artist();
            michael.setName("Michael Jackson");
            artistRepository.save(michael);
        }

//        System.out.println(save.getId());
    }
}
