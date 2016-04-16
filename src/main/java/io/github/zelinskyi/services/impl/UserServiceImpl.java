package io.github.zelinskyi.services.impl;

import io.github.zelinskyi.domain.User;
import io.github.zelinskyi.repositories.UserRepository;
import io.github.zelinskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
