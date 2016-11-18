package io.github.dimazelinskyi.springboot.elastic.services.impl;

import io.github.dimazelinskyi.springboot.elastic.domain.User;
import io.github.dimazelinskyi.springboot.elastic.repositories.UserRepository;
import io.github.dimazelinskyi.springboot.elastic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User find(Long id) {
        return userRepository.findOne(id);
    }
}
