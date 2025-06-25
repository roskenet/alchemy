package de.roskenet.hydrogen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for demonstrating session functionality.
 * <p>
 * This controller provides endpoints for storing and retrieving data from the session.
 */
@RestController
public class SessionController {

    private static final String SESSION_ATTRIBUTE_KEY = "userData";

    /**
     * Stores data in the session.
     *
     * @param data    the data to store
     * @param session the HTTP session
     * @return a confirmation message
     */
    @PostMapping("/api/session")
    public Map<String, String> storeInSession(@RequestBody Map<String, Object> data, HttpSession session) {
        session.setAttribute(SESSION_ATTRIBUTE_KEY, data);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data stored in session");
        response.put("sessionId", session.getId());
        
        return response;
    }

    /**
     * Retrieves data from the session.
     *
     * @param session the HTTP session
     * @return the data stored in the session or an empty map if no data is found
     */
    @GetMapping("/api/session")
    public Map<String, Object> getFromSession(HttpSession session) {
        Object data = session.getAttribute(SESSION_ATTRIBUTE_KEY);
        
        if (data == null) {
            Map<String, Object> emptyResponse = new HashMap<>();
            emptyResponse.put("message", "No data found in session");
            emptyResponse.put("sessionId", session.getId());
            return emptyResponse;
        }
        
        @SuppressWarnings("unchecked")
        Map<String, Object> sessionData = (Map<String, Object>) data;
        sessionData.put("sessionId", session.getId());
        
        return sessionData;
    }
}