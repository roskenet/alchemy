package de.roskenet.riptidedemo.oxygen;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@WireMockTest(httpPort = 30123)
@TestPropertySource(properties = { "riptide.clients.oxygen.base-url=http://localhost:30123/"})
public class OxygenClientTest {

    @Autowired
    private OxygenClient client;

    @Test
    public void testGetSomething_200() {
        var response = client.getSomething("OK");
        Assertions.assertThat(response.value()).isEqualTo("Hello World");
    }

    @Test
    public void testGetSomething_404() {
        try {
            var response = client.getSomething("UNKNOWN");
        } catch (OxygenClientException oce) {
            Assertions.assertThat(oce.getHttpStatus()).isEqualTo(404);
        }
    }

    @Test
    public void testGetSomething_405() {
        try {
            var response = client.getSomething("NOT_ALLOWED");
        } catch (OxygenClientException oce) {
            Assertions.assertThat(oce.getHttpStatus()).isEqualTo(405);
        }
    }

    @Test
    public void testGetSomething_delayed() {
        try {
            var response = client.getSomething("DELAYED");
        } catch (OxygenClientException oce) {
//            oce.printStackTrace();
            Assertions.assertThat(oce.getMessage()).isEqualTo("Error: Unknown");
            return;
        }
        Assertions.fail("We should not get here!");
    }
}
