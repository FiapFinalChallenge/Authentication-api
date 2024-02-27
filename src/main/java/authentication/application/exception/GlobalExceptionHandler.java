package authentication.application.exception;

import authentication.application.exception.dto.ErrorMessage;
import authentication.domain.exception.AuthenticationApiException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthenticationException.class, HttpClientErrorException.class})
    public ErrorMessage handleAuthenticationException(AuthenticationException ex) {
        return new ErrorMessage("token_invalid", "Unknown or expired token.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationApiException.class)
    public ErrorMessage handleAuthenticationApiException(AuthenticationApiException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            var errorMessage = error.getDefaultMessage();
            var fieldName = ((FieldError) error).getField();
            errors.add(new ErrorMessage(errorMessage, fieldName));
        });

        return errors;
    }

}
