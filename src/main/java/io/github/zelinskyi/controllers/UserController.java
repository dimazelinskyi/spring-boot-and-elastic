package io.github.zelinskyi.controllers;

import io.github.zelinskyi.domain.User;
import io.github.zelinskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void create(@RequestBody User user) {
        userService.save(user);
    }
}
