package de.roskenet.riptidedemo;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;
import static org.springframework.http.HttpStatus.Series.SUCCESSFUL;
import static org.zalando.riptide.Bindings.anySeries;
import static org.zalando.riptide.Bindings.anyStatus;
import static org.zalando.riptide.Bindings.on;
import static org.zalando.riptide.Navigators.series;
import static org.zalando.riptide.Navigators.status;

import java.util.concurrent.CompletionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.zalando.riptide.Http;
import org.zalando.riptide.capture.Capture;

@Component
public class OxygenClient {

    @Autowired
    @Qualifier("oxygen")
    private Http http;

    public OxygenResponse getSomething(String input) {
        Capture<OxygenResponse> capture = Capture.empty();
        try {
            return http.get("/api/name/{input}", input)
                    .dispatch(series(),
                            on(SUCCESSFUL).call(OxygenResponse.class, capture),
                            on(CLIENT_ERROR).dispatch(
                                    status(),
                                        on(HttpStatus.NOT_FOUND).call((e) -> {
                                            throw new OxygenClientException(e.getRawStatusCode(), "Not found Error: " + input);
                                        }),
                                        anyStatus().call((e) -> {
                                            throw new OxygenClientException(e.getRawStatusCode(), "General Client Error " + input);
                                        })),
                            on(SERVER_ERROR).dispatch(
                                    status(),
                                        anyStatus().call((e) -> {
                                            throw new OxygenClientException(e.getRawStatusCode(), "General Server Error " + input);
                                        })),
                            anySeries().call((e) -> {
                                    throw new OxygenClientException(e.getRawStatusCode(), "General Error " + input);
                                }))
                    .thenApply(capture)
                    .join();
        } catch (CompletionException ce) {
            throw (OxygenClientException) ce.getCause();
        }
    }
}
