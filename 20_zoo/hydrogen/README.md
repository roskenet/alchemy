# Hydrogen

[Found here](https://www.split.io/blog/tutorial-spring-boot-react/)

For some mystical reason I need to execute:

```sh
npm i -D --save-exact mini-css-extract-plugin@2.4.5
```

## Spring Session Support

This project includes Spring Session with Redis for session management. This allows for:

- HTTP session persistence across application restarts
- Session sharing in a clustered environment
- Centralized session management

### Features

- Uses Redis as the session store
- Includes an embedded Redis server for development (no external Redis required)
- Session timeout configured to 30 minutes

### Usage

The application provides REST endpoints to demonstrate session functionality:

- `POST /api/session` - Store data in the session
  ```json
  {
    "key1": "value1",
    "key2": "value2"
  }
  ```

- `GET /api/session` - Retrieve data from the session

### Configuration

Session configuration is in `application.properties`:

```properties
# Spring Session Configuration
spring.session.store-type=redis
spring.session.redis.namespace=hydrogen:session
spring.session.timeout=30m

# Redis Configuration
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

For production, configure an external Redis server by updating these properties or using environment variables.

### Embedded Redis

The application includes an embedded Redis server for development. This server:

- Starts automatically with the application
- Uses the port specified in `application.properties`
- Is only active in the default profile (development)
- Gracefully handles cases where Redis is already running

To disable the embedded Redis server, run with a non-default profile:

```sh
java -jar hydrogen.jar --spring.profiles.active=prod
```
