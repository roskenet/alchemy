package de.petunia.villadiana;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AxillarisConfig {

   @Value("${app.client.axillaris-url}")
   private String axillarisUrl;

   @Bean
   public WebClient axillarisClient(ClientRegistrationRepository clientRegistrationRepository,
                                    OAuth2AuthorizedClientRepository authorizedClientRepository) {
      var oauth2Filter = new ServletOAuth2AuthorizedClientExchangeFilterFunction(
            clientRegistrationRepository,
            authorizedClientRepository
        );

      oauth2Filter.setDefaultClientRegistrationId("axillaris-client");

      return WebClient.builder()
              .baseUrl(axillarisUrl)
              .apply(oauth2Filter.oauth2Configuration())
            .build();
   }
}
