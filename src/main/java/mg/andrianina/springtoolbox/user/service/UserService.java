package mg.andrianina.springtoolbox.user.service;

import mg.andrianina.springtoolbox.user.domain.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final List<User> users =  List.of(
            new User("test1", "test1@email.com", ""),
            new User("jean", "jean@email.com", ""),
            new User("bob", "bob@email.com", ""),
            new User("john", "john@email.com", "")
    );

    public List<User> getUsersByUsername(String filter) {
        if (filter == null || filter.isBlank()) {
            return users;
        }

        return users
                .stream()
                .filter((element) -> element.username().contains(filter))
                .toList();
    }

    public List<User> getUsersByEmail(String filter) {
        if (filter == null || filter.isBlank()) {
            return users;
        }

        return users
                .stream()
                .filter((element) -> element.email().contains(filter))
                .toList();
    }
}
