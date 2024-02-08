package com.neweltechnologies.portfolio.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neweltechnologies.portfolio.base.BaseController;
import com.neweltechnologies.portfolio.base.IBaseService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserDTO> {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected IBaseService<UserDTO> getService() {
        return userService;
    }
}