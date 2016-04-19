package io.github.zelinskyi.controllers;

import io.github.zelinskyi.domain.User;
import io.github.zelinskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST controller that has two simple methods:
 *
 *  1. Save user - consume User entity in format JSON and save it to Elasticsearch.
 *  2. Find user with id - consume id of User and returns saved entity from Elasticsearch.
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User find(@PathVariable Long id) {
        return userService.find(id);
    }

}
