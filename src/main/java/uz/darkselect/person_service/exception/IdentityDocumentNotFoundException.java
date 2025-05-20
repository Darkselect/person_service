package uz.darkselect.person_service.exception;

public class IdentityDocumentNotFoundException extends RuntimeException {
    public IdentityDocumentNotFoundException(String message) {
        super(message);
    }
}
