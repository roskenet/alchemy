package de.roskenet.hydrogen;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

  @GetMapping("/me")
  public Map<String, Object> me(@AuthenticationPrincipal OidcUser user) {
      return Map.of("name", user.getFullName(), "email", user.getEmail());
  }

  @GetMapping("/downstream")
  public String callApi(@RegisteredOAuth2AuthorizedClient("keycloak")
                        OAuth2AuthorizedClient client) {
      String accessToken = client.getAccessToken().getTokenValue();
      // RestTemplate/WebClient mit Bearer <accessToken> gegen Backend-API ...
      return "Hello from UserController";
  }
}
