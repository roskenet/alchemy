package demo.uranium;

import static demo.uranium.AppProfile.STAGING;
import static org.springframework.security.oauth2.core.authorization.OAuth2AuthorizationManagers.hasScope;

import com.zalando.spring.security.oauth2.server.resource.introspection.ZalandoOpaqueTokenIntrospector;
import com.zalando.spring.security.oauth2.server.resource.introspection.roles.HttpUserRoleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile(STAGING)
public class SecurityConfig {

    @Value("${tokeninfo.introspector.uri}")
    private String introspectorUri;

    @Value("${tokeninfo.userroles.uri}")
    private String userrolesUri;

    @Bean
    public OpaqueTokenIntrospector introspector() {
        RestOperations restOperations = new RestTemplate();
        return new ZalandoOpaqueTokenIntrospector(
                introspectorUri,
                restOperations,
                new HttpUserRoleProvider(userrolesUri, restOperations));
    }

    // Another way to configure security instead of using the @PreAuthorize or @Secured annotation:

//    @Bean
//    @Profile("staging")
//    public SecurityFilterChain filterChainAuth(HttpSecurity http, OpaqueTokenIntrospector introspector) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/actuator/**").permitAll()
//                .requestMatchers("/hello").access(hasScope("offerable-quantity.read"))
//                .anyRequest().authenticated()
//            )
//            .oauth2ResourceServer(oauth2 -> oauth2
//                .opaqueToken(opaqueToken -> opaqueToken
//                        .introspector(introspector)
//                )
//            );
//        return http.build();
//    }
}
