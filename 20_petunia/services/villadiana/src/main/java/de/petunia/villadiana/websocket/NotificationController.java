package de.petunia.villadiana.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    public record StompMessage(String message) {}

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/api/test-message")
    public void sendTestMessage(@RequestBody StompMessage message) {
        messagingTemplate.convertAndSend("/topic/petunias", message.message +" 🌸");
    }
}
