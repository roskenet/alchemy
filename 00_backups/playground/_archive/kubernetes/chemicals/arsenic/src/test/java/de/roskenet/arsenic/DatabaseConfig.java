package de.roskenet.arsenic;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import java.io.IOException;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() throws IOException {
        PGSimpleDataSource dataSource = (PGSimpleDataSource) EmbeddedPostgres.start().getPostgresDatabase();
        return dataSource;
    }
}
