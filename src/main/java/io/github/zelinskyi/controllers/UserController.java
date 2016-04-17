package io.github.zelinskyi.controllers;

import io.github.zelinskyi.domain.User;
import io.github.zelinskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST controller that consume User entity in format JSON
 * and converts it to plain java object.
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userService.save(user);
    }


}
