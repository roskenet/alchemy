package de.petunia.villadiana.websocket;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserNotification {
    public UserMessage getMessageForUser() {
        var randomUUID = UUID.randomUUID();
        var userName = "Unknown";

        SecurityContext context = SecurityContextHolder.getContext();

        if(context.getAuthentication() != null) {
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return new UserMessage(userName, randomUUID.toString());
    }

}
