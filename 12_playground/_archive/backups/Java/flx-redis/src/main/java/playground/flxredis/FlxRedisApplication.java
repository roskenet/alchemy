package playground.flxredis;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class FlxRedisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FlxRedisApplication.class, args);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ProtokollRepository protokollRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");

        Protokoll newProtokoll = new Protokoll();
        newProtokoll.setPort("8080");
        newProtokoll.setProtokoll("tomcat");

        protokollRepository.save(newProtokoll);

        Optional<Protokoll> tomcat = protokollRepository.findById("tomcat");

        System.out.println(tomcat.orElse(null).getProtokoll());
        System.out.println(tomcat.orElse(null).getPort());
    }

    public String doSomething() {
        return "Nüscht!";
    }
}
