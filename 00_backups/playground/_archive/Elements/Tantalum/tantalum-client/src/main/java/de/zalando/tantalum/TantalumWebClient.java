package de.zalando.tantalum;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TantalumWebClient implements TantalumClient {

    @Value("${tantalum.url:http://localhost:8080}")
    private String tantalumUrl;
    
    private RestTemplate restTemplate;
    
    public TantalumWebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public List<Car> getAllCars() {
        ResponseEntity<List<Car>> carsResponse = 
                restTemplate.exchange(tantalumUrl + "/api/cars", 
                                      HttpMethod.GET,
                                      null,
                                      new ParameterizedTypeReference<List<Car>>() {});
        
        return carsResponse.getBody();
    }
}
