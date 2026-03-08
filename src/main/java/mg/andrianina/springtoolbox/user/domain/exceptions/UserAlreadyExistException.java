package mg.andrianina.springtoolbox.user.domain.exceptions;

public class UserAlreadyExistException  extends RuntimeException {
    public UserAlreadyExistException() {
        super("A user with this username or email already exist");
    }
}
