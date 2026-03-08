package mg.andrianina.springtoolbox.user.api.controllers;

import mg.andrianina.springtoolbox.user.api.dto.UserDto;
import mg.andrianina.springtoolbox.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsersByUsername(@RequestParam(required = false) String username) {
        return userService.getUsersByUsername(username).stream().map(UserDto::fromUser).toList();
    }

    @GetMapping("/{email}")
    public List<UserDto> getUsersByEmail(@PathVariable  String email) {
        return userService.getUsersByEmail(email).stream().map(UserDto::fromUser).toList();
    }
}
