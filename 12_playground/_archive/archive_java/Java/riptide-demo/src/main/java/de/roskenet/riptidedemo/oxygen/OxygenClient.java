package de.roskenet.riptidedemo.oxygen;

import static org.springframework.http.HttpStatus.Series.SUCCESSFUL;
import static org.zalando.riptide.Bindings.anySeries;
import static org.zalando.riptide.Bindings.on;
import static org.zalando.riptide.Navigators.series;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Supplier;
import org.springframework.http.client.ClientHttpResponse;
import org.zalando.riptide.Http;
import org.zalando.riptide.capture.Capture;

public class OxygenClient {
    private Http http;

    public OxygenClient(Http http) {
        this.http = http;
    }

    public OxygenResponse getSomething(String input) {
        Capture<OxygenResponse> capture = Capture.empty();

        return httpCall(http.get("/api/name/{input}", input)
                .dispatch(series(),
                        on(SUCCESSFUL).call(OxygenResponse.class, capture),
                        anySeries().call((e) -> handleError(e, "Error: ", input))
                ).thenApply(capture)::join);
    }

    public static void handleError(ClientHttpResponse resp, String fmtString, Object... obj) throws IOException {
        throw new OxygenClientException(resp.getRawStatusCode(), String.format(fmtString, obj));
    }

    public static <R> R httpCall(Supplier<R> function) {
        try {
            return function.get();
        } catch (CompletionException ce) {
            throw ce.getCause() instanceof OxygenClientException ?
                    (OxygenClientException) ce.getCause() :
                    new OxygenClientException(0, "Error: Unknown", ce.getCause());
        }
    }

}
