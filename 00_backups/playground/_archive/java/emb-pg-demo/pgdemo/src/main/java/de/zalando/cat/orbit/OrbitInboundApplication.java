package de.zalando.cat.orbit;

//import java.util.TimeZone;
//import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
//import org.zalando.nakadiproducer.EnableNakadiProducer;

@SpringBootApplication
//@EnableNakadiProducer
//@EntityScan(basePackageClasses = {OrbitInboundApplication.class, Jsr310JpaConverters.class})
public class OrbitInboundApplication {

    @Value("${application.timezone:UTC+1}")
    private String applicationTimezone;

//    @PostConstruct
//    void started() {
//        TimeZone.setDefault(TimeZone.getTimeZone(applicationTimezone));
//    }

    public static void main(String[] args) {
        SpringApplication.run(OrbitInboundApplication.class, args);
    }
}
