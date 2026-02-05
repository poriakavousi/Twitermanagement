package com.twitter.service;

import com.twitter.base.service.BaseService;
import com.twitter.entity.User;

public interface UserService extends BaseService<User,Long> {
    public User loginToSystem(String username, String password);
    User findByUsername(String username);
}
