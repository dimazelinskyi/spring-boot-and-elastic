package io.github.dimazelinskyi.services;


import io.github.dimazelinskyi.domain.User;

public interface UserService {

    void save(User user);
    User find(Long id);
}
