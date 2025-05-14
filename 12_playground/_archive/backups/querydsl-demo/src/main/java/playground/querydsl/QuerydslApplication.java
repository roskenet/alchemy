package playground.querydsl;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.IOException;

@SpringBootApplication
public class QuerydslApplication implements CommandLineRunner {

    @Autowired
    private ArtistService artistService;

    @Bean
    public DataSource dataSource() throws IOException {
          return EmbeddedPostgres.start().getPostgresDatabase();
    }

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        artistService.getFiltered().stream().map(Artist::getName).forEach(System.out::println);
    }
}
