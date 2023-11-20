package com.api.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Castro
 */
@Component
public class JmsReceiver {
    
    @JmsListener(destination = "notification")
    public void receiverMessage(String message) {
        System.out.println("Notification: " + message);
    }
}
