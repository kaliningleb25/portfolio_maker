package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.dao.UserRepository;
import com.kaliningleb25.portfolio_maker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findUserByNickname(String userNickname) {
        return userRepository.findUserByNickname(userNickname);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
