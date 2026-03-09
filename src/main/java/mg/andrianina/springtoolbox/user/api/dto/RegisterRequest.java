package mg.andrianina.springtoolbox.user.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mg.andrianina.springtoolbox.user.util.Password;


// This is a payload of an api that is validated by the spring library.
public record RegisterRequest(
        @Email(message = "Must be a valid email")
        @NotBlank(message = "Email shouldn't be empty")
        String email,
        @NotBlank(message = "Username shouldn't be empty")
        String username,
        @Password
        String password
) {}
