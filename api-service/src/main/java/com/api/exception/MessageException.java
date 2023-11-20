package com.api.exception;

/**
 *
 * @author Miguel Castro
 */
public class MessageException {
    
    private String messageUser;
    
    private String messageDeveloper;
    
    public MessageException(String messageUser, String messageDeveloper) {
        this.messageUser = messageUser;
        this.messageDeveloper = messageDeveloper;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getMessageDeveloper() {
        return messageDeveloper;
    }

    public void setMessageDeveloper(String messageDeveloper) {
        this.messageDeveloper = messageDeveloper;
    }
}
