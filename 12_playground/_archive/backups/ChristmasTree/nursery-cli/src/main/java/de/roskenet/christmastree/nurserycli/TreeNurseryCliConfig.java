package de.roskenet.christmastree.nurserycli;

import de.roskenet.christmastree.ChristmasTreeNursery;
import de.roskenet.christmastree.StringChristmasTreeNursery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TreeNurseryCliConfig {

    @Bean
    @Profile("default")
    public ChristmasTreeNursery christmasTreeNursery() {
        return new StringChristmasTreeNursery();
    }

    @Bean
    @Profile("test")
    public ChristmasTreeNursery mockChristmasTreeNursery() {
        return new ChristmasTreeNursery() {
            @Override
            public String tree(int i) {
                return "";
            }
        };
    }
}
