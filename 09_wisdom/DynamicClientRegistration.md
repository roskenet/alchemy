# Dynamic Client Registration Request

Dynamic Client Registration enables clients to create new client entries on the server without requiring manual intervention. This is particularly useful for applications that need to scale or for environments where clients are frequently added or removed.

### Example 1: Dynamic Client Registration Request
Here’s an example of how a client might send a registration request to Keycloak:

```http
POST /auth/realms/{realm}/clients-registrations/openid-connect HTTP/1.1
Host: {keycloak-server}
Content-Type: application/json

{
  "client_id": "my-new-client",
  "client_name": "My New Client",
  "redirect_uris": ["https://myapp.com/callback"],
  "grant_types": ["authorization_code"],
  "response_types": ["code"]
}
```

### Example 2: Dynamic Client Registration Response
The server responds with the details of the newly registered client:

```json
{
  "client_id": "my-new-client",
  "client_secret": "generated-client-secret",
  "registration_access_token": "access-token",
  "registration_client_uri": "https://{keycloak-server}/auth/realms/{realm}/clients-registrations/openid-connect/my-new-client"
}
```

In this example, the client sends a JSON payload to register itself, and the server responds with the client ID and secret, among other details.
