package com.neweltechnologies.portfolio.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neweltechnologies.portfolio.base.BaseController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, Long> {

    public UserController(UserService userService) {
        super(userService);
    }
}
