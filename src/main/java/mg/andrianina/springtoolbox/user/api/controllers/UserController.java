package mg.andrianina.springtoolbox.user.api.controllers;

import mg.andrianina.springtoolbox.user.api.dto.UserDto;
import mg.andrianina.springtoolbox.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*** Every class that exposes api have to be annotated with the @RestController annotation. For a better organization,
 * the controller should also be annotated with a @RequestMapping annotation with the base path as parameter
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /***
     * This method is an endpoint using the get method with a request parameter.
     * @param username String. This argument annotated with @RequestParam annotation is the request parameter of the endpoint.
     *                 If a name is not specified in the annotation, the name of the parameter is the same as the method
     *                 argument
     * @return The response of the api
     */
    @GetMapping
    public List<UserDto> getUsersByUsername(@RequestParam(required = false) String username) {
        return userService.getUsersByUsername(username).stream().map(UserDto::fromUser).toList();
    }

    /***
     * This method is an endpoint using the get method with a path variable
     * @param email String. This argument annotated with the @PathVariable annotation is the path variable of the endpoint.
     *              The name of the path variable should be the same as the argument's name.
     * @return The response of the api
     */
    @GetMapping("/{email}")
    public List<UserDto> getUsersByEmail(@PathVariable  String email) {
        return userService.getUsersByEmail(email).stream().map(UserDto::fromUser).toList();
    }
}
