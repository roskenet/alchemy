package de.roskenet.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EnvApplicationBeanConfig {

    @Profile("dev")
    @Bean
    public EnvApplicationBean getDevApplicationBean(AnotherBean anotherBean) {
        return new DevApplicationBean(anotherBean);
    }

    @Profile("default")
    @Bean
    public EnvApplicationBean getStandardApplicationBean(AnotherBean anotherBean) {
        return new StdApplicationBean(anotherBean);
    }
}
