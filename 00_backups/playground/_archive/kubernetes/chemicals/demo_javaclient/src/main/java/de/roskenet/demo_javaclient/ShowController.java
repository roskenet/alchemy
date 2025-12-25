package de.roskenet.demo_javaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultClientCredentialsTokenResponseClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShowController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/show")
    public Map<String, String> showSomething() {

        var block = webClient.get()
                .uri("http://localhost:9191/myresource")
                .attributes(
                        ServerOAuth2AuthorizedClientExchangeFilterFunction
                                .clientRegistrationId("hydrogen")
                )
                .retrieve()
                .toEntityList(String.class)
                .block();

        var responseMap = new HashMap<String, String>();
        responseMap.put("myresource", block.toString());
        return responseMap;
    }
}
