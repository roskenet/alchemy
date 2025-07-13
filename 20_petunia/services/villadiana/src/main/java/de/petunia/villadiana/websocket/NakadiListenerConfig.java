package de.petunia.villadiana.websocket;

import nakadi.NakadiClient;
import nakadi.StreamConfiguration;
import nakadi.StreamProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
public class NakadiListenerConfig {

    public StreamConfiguration nakadiStream() {
        StreamConfiguration sc = new StreamConfiguration()
                .eventTypeName("petunia.message.user")
                .maxUncommittedEvents(10L);
        return sc;
    }

    @Bean
    public StreamProcessor nakdiStreamProcessor(NakadiClient client, SimpMessagingTemplate template) {
        StreamProcessor boundedProcessor = client.resources().streamBuilder()
                .streamConfiguration(nakadiStream())
                .streamObserverFactory(new UserMessageObserverProvider(template))
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
