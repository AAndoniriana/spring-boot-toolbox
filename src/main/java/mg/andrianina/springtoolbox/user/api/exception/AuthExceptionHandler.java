package mg.andrianina.springtoolbox.user.api.exception;

import mg.andrianina.springtoolbox.user.domain.exceptions.UserAlreadyExistException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

// Every class that handles Exception must be annotated with the @RestControllerAdvice
@RestControllerAdvice
public class AuthExceptionHandler {
    /***
     * Each method that handles exception should be annotated with the @ExceptionHandler annotation with the type of
     * exception that it handle as a parameter
     * @param e UserAlreadyExistException the exception that this method handle
     * @return Map<String, String> as json
     */
    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> onUserAlreadyExistException(UserAlreadyExistException e) {
        return Map.of(
                "code", "USER_EXISTS",
                "message", e.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> onValidationException(MethodArgumentNotValidException e) {
        List<String> errors = e
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        return Map.of(
                "code", "VALIDATION_ERROR",
                "message", errors
        );
    }
}
