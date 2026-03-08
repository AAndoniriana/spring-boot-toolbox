package mg.andrianina.springtoolbox.user.domain.models;

public record User(
        String username,
        String email,
        String password
) { }
