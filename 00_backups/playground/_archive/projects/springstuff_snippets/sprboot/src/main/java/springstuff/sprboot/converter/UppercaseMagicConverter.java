package springstuff.sprboot.converter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Profile("magic")
// https://reflectoring.io/dont-use-spring-profile-annotation/
public class UppercaseMagicConverter implements MagicConverter {
    @Override
    public String convert(String arg) {
        return arg.toUpperCase(Locale.ROOT);
    }
}
