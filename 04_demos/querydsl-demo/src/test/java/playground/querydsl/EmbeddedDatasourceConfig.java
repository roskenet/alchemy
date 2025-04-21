package playground.querydsl;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class EmbeddedDatasourceConfig {
    @Bean
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgres.start().getPostgresDatabase();
    }
}