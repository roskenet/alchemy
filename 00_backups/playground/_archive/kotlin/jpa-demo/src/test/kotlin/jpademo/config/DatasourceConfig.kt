package jpademo.config

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

// If you want to persist your data in a "real" PostgreSQL DB
// just disable this Configuration.
@Configuration
class DatasourceConfig {
    @Bean
    fun dataSource(): DataSource {
        return EmbeddedPostgres.builder().start().postgresDatabase
    }
}