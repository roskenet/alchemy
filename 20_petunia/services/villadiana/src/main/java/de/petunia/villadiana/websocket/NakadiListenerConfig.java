package de.petunia.villadiana.websocket;

import nakadi.Event;
import nakadi.LoggingStreamObserverProvider;
import nakadi.NakadiClient;
import nakadi.SimpleStreamObserverFactory;
import nakadi.StreamConfiguration;
import nakadi.StreamProcessor;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NakadiListenerConfig {

    public StreamConfiguration nakadiStream() {
        StreamConfiguration sc = new StreamConfiguration()
                .eventTypeName("petunia.message.user")
                .maxUncommittedEvents(10L);
        return sc;
    }

    @Bean
    public StreamProcessor nakdiStreamProcessor(NakadiClient client) {
        StreamProcessor boundedProcessor = client.resources().streamBuilder()
                .streamConfiguration(nakadiStream())
                .streamObserverFactory(new LoggingStreamObserverProvider())
                .build();

        boundedProcessor.start();

        return boundedProcessor;
    }

    @Bean
    public NakadiClient nakadiClient() {
        NakadiClient client = NakadiClient.newBuilder()
                .baseURI("http://nakadi.minikube")
                .build();
        return client;
    }
}
