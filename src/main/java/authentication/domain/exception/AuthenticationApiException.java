package authentication.domain.exception;

public class AuthenticationApiException extends RuntimeException {

    public AuthenticationApiException(String message) {
        super(message);
    }
}
