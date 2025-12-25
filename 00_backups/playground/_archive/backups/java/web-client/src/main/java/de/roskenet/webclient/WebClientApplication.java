package de.roskenet.webclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.zalando.riptide.AttributeStage;
import org.zalando.riptide.Http;
import org.zalando.riptide.capture.Capture;
import org.zalando.riptide.capture.CaptureException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static org.springframework.http.HttpStatus.Series.SUCCESSFUL;
import static org.zalando.riptide.Bindings.on;
import static org.zalando.riptide.Navigators.series;

@SpringBootApplication
public class WebClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
    }

    public static void printResponse(MyResponse theResponse) {
        System.out.println("TheString: " + theResponse.getTheString());
        System.out.println("TheInteger: " + theResponse.getTheInteger());
    }

    @Override
    public void run(String... args) throws Exception {
        final Http http = Http.builder()
                .executor(Executors.newCachedThreadPool())
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .build();

        Capture<MyResponse> capture = Capture.empty();

        MyResponse myResponse = http.get("http://localhost:8080/hello")
                .dispatch(series(),
                        on(SUCCESSFUL).call(MyResponse.class, capture))
                .thenApply(capture)
                .join();

        System.out.println(myResponse.getTheInteger());

//        http.get("http://localhost:8080/hello")

//                .dispatch(series(),
//                        on(SUCCESSFUL).call(MyResponse.class, WebClientApplication::printResponse));
//                .join();

    }

//    DigitalRackArticle digitalRackArticle = client
//            .put(new
//                    UriTemplate(CONTENT_URL).expand(articleRequest.getConfigSku()))
//            .attribute(OPERATION_NAME, "put_content_rack_article")
//            .body(articleRequest)
//            .dispatch(series(),
//
//                    on(SUCCESSFUL).call(DigitalRackArticle.class, capture),
//                    on(CLIENT_ERROR).dispatch(status(),
//                            on(NOT_FOUND).call(r ->
//                                    digitalRackServiceError(String.format(SKU_NOT_FOUND_MSG,
//                                            getResponseBodyAsString(r.getBody())))),
//                            anyStatus().call(r ->
//                                    digitalRackServiceError(String.format(UNEXPECTED_CLIENT_ERROR_MSG,
//                                            getResponseBodyAsString(r.getBody()))))),
//                    on(SERVER_ERROR).dispatch(status(),
//                            on(BAD_GATEWAY).call(r ->
//                                    digitalRackServiceError(String.format(BAD_GATEWAY_MSG,
//                                            getResponseBodyAsString(r.getBody())))),
//                            on(SERVICE_UNAVAILABLE)
//                                    .call(r ->
//                                            digitalRackServiceError(String.format(SERVICE_UNAVAILABLE_MSG,
//                                                    getResponseBodyAsString(r.getBody())))),
//                            anyStatus().call(r ->
//                                    digitalRackServiceError(String.format(OTHER_SERVER_ERROR_MSG,
//                                            getResponseBodyAsString(r.getBody()))))),
//                    anySeries().call(() ->
//                            digitalRackServiceError(UNEXPECTED_RESPONSE_MSG)))
//            .thenApply(capture)
//            .join();
}
