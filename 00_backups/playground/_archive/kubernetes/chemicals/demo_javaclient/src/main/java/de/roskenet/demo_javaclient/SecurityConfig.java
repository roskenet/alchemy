package de.roskenet.demo_javaclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.endpoint.DefaultClientCredentialsTokenResponseClient;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SecurityConfig {

	@Bean
	public WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
		ServletOAuth2AuthorizedClientExchangeFilterFunction filter =
				new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
		return WebClient.builder()
				.apply(filter.oauth2Configuration())
				.build();
	}

    @Bean
    public DefaultClientCredentialsTokenResponseClient clientCredentialsAccessTokenResponseClient(RestTemplateBuilder rtBuilder) {
        DefaultClientCredentialsTokenResponseClient accessTokenResponseClient =
                new DefaultClientCredentialsTokenResponseClient();
        accessTokenResponseClient.setRestOperations(rtBuilder.build());

        return accessTokenResponseClient;
    }

    // This is not needed... Only here to play with the new functional config styles:
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests(
//                (a) -> a.requestMatchers("/**").authenticated()
//                        .requestMatchers("/hello").hasRole("ROLE_somerole")
//        ).build();
//			.oauth2Client(Customizer.withDefaults());
//	}

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService authorizedClientService) {

        OAuth2AuthorizedClientProvider authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .clientCredentials()
                        .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                        clientRegistrationRepository, authorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
           web.ignoring().requestMatchers("/**");
    }
}
