package playground.querydsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuerydslApplication implements CommandLineRunner {

    @Autowired
    private ArtistService artistService;

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");

        ArtistService.SearchParams params =
                new ArtistService.SearchParams("Prince");

        artistService.getFiltered(params).stream()
                .map(Artist::getName)
                .forEach(System.out::println);

    }
}
