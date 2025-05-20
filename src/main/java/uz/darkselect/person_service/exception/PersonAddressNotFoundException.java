package uz.darkselect.person_service.exception;

public class PersonAddressNotFoundException extends RuntimeException {
    public PersonAddressNotFoundException(String message) {
        super(message);
    }
}
