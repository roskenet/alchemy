package de.roskenet.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GanymedeService {

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    @Autowired
    public GanymedeService(OAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }

    public Artist makeApiCall() {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("io")
                .principal("io-client")
                .build();

        OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(authorizeRequest);

        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        WebClient webClient = WebClient.builder()
                .baseUrl("http://ganymede.minikube")
                .defaultHeader("Authorization", "Bearer " + accessToken)
                .build();

        return webClient.get()
                .uri("/artist/42")
                .retrieve()
                .bodyToMono(Artist.class)
                .block();
    }
}
