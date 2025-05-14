package springstuff.sprboot.converter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
// https://reflectoring.io/dont-use-spring-profile-annotation/
public class NoopMagicConverter implements MagicConverter {
    @Override
    public String convert(String arg) {
        return arg;
    }
}
