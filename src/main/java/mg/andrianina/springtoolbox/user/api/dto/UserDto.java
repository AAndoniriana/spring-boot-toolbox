package mg.andrianina.springtoolbox.user.api.dto;

import mg.andrianina.springtoolbox.user.domain.models.User;

public record UserDto(
        String username,
        String email,
        String password
){
    public static UserDto fromUser(User user) {
        return new UserDto(user.username(), user.email(), user.password());
    }
}
