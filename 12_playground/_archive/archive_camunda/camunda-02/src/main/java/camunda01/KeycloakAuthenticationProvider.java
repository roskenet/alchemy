package camunda01;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.rest.security.auth.AuthenticationResult;
import org.camunda.bpm.engine.rest.security.auth.impl.ContainerBasedAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * OAuth2 Authentication Provider for usage with KeycloakIdentityProviderPlugin.
 */
public class KeycloakAuthenticationProvider
        extends ContainerBasedAuthenticationProvider {

    @Override
    public AuthenticationResult extractAuthenticatedUser(HttpServletRequest request,
            ProcessEngine engine) {

        // Extract authentication details
//        OAuth2Authentication authentication = (OAuth2Authentication)
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return AuthenticationResult.unsuccessful();
        }
        var principal = authentication.getPrincipal();
        if (principal == null ) {
            return AuthenticationResult.unsuccessful();
        }

        // Extract user ID from Keycloak authentication result
        // depending on plugin configuration
//        String userId = ((HashMap<String, String>) userAuthentication.getDetails())
//                .get("email");              // useEmailAsCamundaUserId = true
        //  .get("preferred_username"); // useUsernameAsCamundaUserId = true
        //  .get("sub");                // use internal ID

        authentication.getAuthorities();

        // Authentication successful
        AuthenticationResult authenticationResult =
                new AuthenticationResult("felix", true);
        authenticationResult.setGroups(getUserGroups("felix", engine));

        return authenticationResult;
    }

    private List<String> getUserGroups(String userId, ProcessEngine engine){
        List<String> groupIds = new ArrayList<>();
        // query groups using KeycloakIdentityProvider plugin
        engine.getIdentityService().createGroupQuery().groupMember(userId).list()
                .forEach( g -> groupIds.add(g.getId()));
        return groupIds;
    }

}