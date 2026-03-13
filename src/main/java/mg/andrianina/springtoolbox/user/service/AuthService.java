package mg.andrianina.springtoolbox.user.service;

import mg.andrianina.springtoolbox.user.domain.exceptions.UserAlreadyExistException;
import mg.andrianina.springtoolbox.user.domain.models.User;
import mg.andrianina.springtoolbox.user.infra.database.UserRepository;
import mg.andrianina.springtoolbox.user.infra.database.entities.UserEntity;
import mg.andrianina.springtoolbox.user.infra.database.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String email, String username, String password) {
        String trimmedEmail = email.trim();
        String trimmedUsername = username.trim();
        List<UserEntity> existingUser = userRepository.findByEmailOrUsername(trimmedEmail, trimmedUsername);
        if (!existingUser.isEmpty()) {
            throw new UserAlreadyExistException();
        }
        UserEntity newUser = new UserEntity();
        newUser.password = password;
        newUser.username = trimmedUsername;
        newUser.email = trimmedEmail;
        UserEntity userEntity = userRepository.save(newUser);
        return UserMapper.entityToDomain(userEntity);
    }

}
