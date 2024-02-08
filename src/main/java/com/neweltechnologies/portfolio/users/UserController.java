package com.neweltechnologies.portfolio.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neweltechnologies.portfolio.base.BaseController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<Long, User, UserDTO> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
