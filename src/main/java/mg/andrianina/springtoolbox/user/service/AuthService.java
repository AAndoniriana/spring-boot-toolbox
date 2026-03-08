package mg.andrianina.springtoolbox.user.service;

import mg.andrianina.springtoolbox.user.domain.exceptions.UserAlreadyExistException;
import mg.andrianina.springtoolbox.user.domain.models.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public User register(String email, String username, String password) {
        if (username.contains("exception") || email.contains("exception")) {
            throw new UserAlreadyExistException();
        }
        return new User(username, email, password);
    }

}
