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

/*** Every class that exposes api have to be annotated with the @RestController annotation. For a better organization,
 * the controller should also be annotated with a @RequestMapping annotation with the base path as parameter
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /***
     * This is an endpoint using the post method
     * @param body RegisterRequest. This is the body of the endpoint. It has to be annotated with @RequestBody.
     *             The @Valid annotation is used to validate the payload of the endpoint using the spring validation libary
     * @return The response of the api.
     */
    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody RegisterRequest body) {
        User user = authService.register(body.email(), body.username(), body.password());
        return UserDto.fromUser(user);
    }
}
