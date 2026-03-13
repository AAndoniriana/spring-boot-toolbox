package mg.andrianina.springtoolbox.user.service;

import mg.andrianina.springtoolbox.user.domain.models.User;
import mg.andrianina.springtoolbox.user.infra.database.UserRepository;
import mg.andrianina.springtoolbox.user.infra.database.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByUsername(String filter) {
        if (filter == null || filter.isBlank()) {
            return userRepository.findAll()
                    .stream()
                    .map(UserMapper::entityToDomain)
                    .toList();
        }

        return userRepository.findByUsername(filter)
                .stream()
                .map(UserMapper::entityToDomain)
                .toList();
    }

    public List<User> getUsersByEmail(String filter) {
        if (filter == null || filter.isBlank()) {
            return userRepository.findAll()
                    .stream()
                    .map(UserMapper::entityToDomain)
                    .toList();
        }

        return userRepository.findByEmail(filter)
                .stream()
                .map(UserMapper::entityToDomain)
                .toList();
    }
}
