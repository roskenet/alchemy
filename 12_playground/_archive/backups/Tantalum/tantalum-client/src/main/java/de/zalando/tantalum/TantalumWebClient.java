package de.zalando.tantalum;

import static org.springframework.http.HttpStatus.Series.SUCCESSFUL;
import static org.zalando.riptide.Bindings.on;
import static org.zalando.riptide.Navigators.contentType;
import static org.zalando.riptide.Navigators.series;
import static org.zalando.riptide.Route.call;
import static org.zalando.riptide.Types.listOf;

import de.zalando.tantalum.TantalumClient;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.zalando.riptide.Http;
import org.zalando.riptide.OriginalStackTracePlugin;
import org.zalando.riptide.capture.Capture;

@Component
public class TantalumWebClient implements TantalumClient {

//    @Value("${tantalum.url:http://localhost:8080}")
//    private String tantalumUrl;
    
//    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("tantalum")
    private Http http;

    @Override
    public List<Car> getAllCars() {
//        ResponseEntity<List<Car>> carsResponse =
//                restTemplate.exchange(tantalumUrl + "/api/cars",
//                                      HttpMethod.GET,
//                                      null,
//                                      new ParameterizedTypeReference<List<Car>>() {});
        
//        return carsResponse.getBody();

        Capture<Car[]> capture = Capture.empty();

        Car[] cars = http.get("/api/cars")
                .dispatch(series(),
                        on(SUCCESSFUL).dispatch(
                                contentType(),
                                on(MediaType.APPLICATION_JSON)
                                        .call(Car[].class, capture)
                        )).thenApply(capture).join();

//        http.get("/repos/{org}/{repo}/contributors", "zalando", "riptide")
//                .dispatch(series(),
//                        on(SUCCESSFUL).call(listOf(User.class), users ->
//                                users.forEach(System.out::println)));

        return Arrays.asList(cars);
    }
}
