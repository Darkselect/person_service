package uz.darkselect.person_service.handler;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message) {

    public ErrorResponse(int status, String error, String message) {
        this(LocalDateTime.now(), status, error, message);
    }
}
