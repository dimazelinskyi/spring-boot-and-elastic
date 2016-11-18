package io.github.dimazelinskyi.services.impl;

import io.github.dimazelinskyi.domain.User;
import io.github.dimazelinskyi.repositories.UserRepository;
import io.github.dimazelinskyi.services.UserService;
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
