package mg.andrianina.springtoolbox.user.api.controllers;

import jakarta.validation.Valid;
import mg.andrianina.springtoolbox.user.api.dto.RegisterRequest;
import mg.andrianina.springtoolbox.user.api.dto.UserDto;
import mg.andrianina.springtoolbox.user.domain.models.User;
import mg.andrianina.springtoolbox.user.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody RegisterRequest body) {
        User user = authService.register(body.email(), body.username(), body.password());
        return UserDto.fromUser(user);
    }
}
