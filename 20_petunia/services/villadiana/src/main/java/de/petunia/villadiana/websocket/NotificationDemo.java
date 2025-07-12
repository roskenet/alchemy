package de.petunia.villadiana.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class NotificationDemo {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationDemo(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRateString = "3000")
    public void sendNotification() {
        var randomUUID = UUID.randomUUID();
        messagingTemplate.convertAndSend("/topic/petunias", randomUUID.toString());
    }
}
