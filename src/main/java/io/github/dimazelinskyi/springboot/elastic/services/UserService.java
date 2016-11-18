package io.github.dimazelinskyi.springboot.elastic.services;


import io.github.dimazelinskyi.springboot.elastic.domain.User;

public interface UserService {

    void save(User user);
    User find(Long id);
}
