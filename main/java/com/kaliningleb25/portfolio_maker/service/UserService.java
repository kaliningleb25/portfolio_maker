package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.entity.User;

import java.util.List;

public interface UserService {
    User findUser(Long id);

    List<User> findAll();
}
