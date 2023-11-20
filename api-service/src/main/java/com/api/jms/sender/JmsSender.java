package com.api.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Castro
 */
@Component
public class JmsSender {

    @Autowired
    private JmsTemplate template;

    public void sendMessage(String message) {
        template.convertAndSend("notification", message);
    }
}
