package de.petunia.villadiana.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    public record StompMessage(String message) {}


    @PostMapping("/api/test-message")
    public void sendTestMessage(@RequestBody StompMessage message) {
        messagingTemplate.convertAndSend("/topic/petunias", message.message +" 🌸");
    }
}
