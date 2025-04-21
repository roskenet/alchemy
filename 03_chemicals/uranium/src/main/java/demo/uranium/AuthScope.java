package demo.uranium;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "scope")
public class AuthScope {

    // Use this prefix with Zalando application scopes and
    // the hasAuthority method.
    private static final String PREFIX = "SCOPE_";

    private String helloRead;

    public void setHelloRead(String helloRead) {
        this.helloRead = helloRead;
    }

    public String getHelloRead() {
        return PREFIX + helloRead;
    }
}
