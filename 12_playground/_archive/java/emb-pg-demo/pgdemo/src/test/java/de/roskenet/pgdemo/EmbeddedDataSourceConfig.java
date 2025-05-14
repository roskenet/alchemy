package de.roskenet.pgdemo;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EmbeddedDataSourceConfig {
    @Bean
    @Profile({"test"})
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgres.builder()
                .start()
                .getPostgresDatabase();
    }
}
