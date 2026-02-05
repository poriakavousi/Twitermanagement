package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.entity.User;

public interface UserRepository extends BaseRepository<User,Long> {
     User loginToSystem(String username, String password);
     User findByUsername(String username);
}
