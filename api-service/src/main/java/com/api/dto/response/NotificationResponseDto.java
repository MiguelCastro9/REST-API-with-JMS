package com.api.dto.response;

import java.time.LocalDateTime;

/**
 *
 * @author Miguel Castro
 */
public class NotificationResponseDto {

    private String message;

    private LocalDateTime message_date;

    public NotificationResponseDto() {
    }

    public NotificationResponseDto(String message, LocalDateTime message_date) {
        this.message = message;
        this.message_date = message_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessage_date() {
        return message_date;
    }

    public void setMessage_date(LocalDateTime message_date) {
        this.message_date = message_date;
    }
}
