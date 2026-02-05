package com.twitter.service;

import com.twitter.base.service.BaseServiceImpl;
import com.twitter.entity.User;
import com.twitter.repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserRepository> implements UserService {


    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User loginToSystem(String username, String password) {
        return repository.loginToSystem(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
