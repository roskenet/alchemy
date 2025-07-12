package de.petunia.villadiana.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationDemo {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private UserNotification userNotification;

    public NotificationDemo(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void startSendNotification(String principalName) {
        log.info("Start sending notifications for " + principalName);

        Runnable theRunnable = () -> {

            for (int i = 0; i < 1000000; i++) {
                UserMessage message = userNotification.getMessageForUser();
                log.info("Sending message: {} for {}", message.message(), principalName);
                messagingTemplate.convertAndSendToUser(
                        principalName,
                        "/queue/petunias", message.message());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(theRunnable);
        thread.start();

    }
}
