package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.entity.Twitt;
import com.twitter.entity.User;

import java.util.List;

public interface TwittRepopsitory extends BaseRepository<Twitt,Long> {
    List<Twitt> findByContent(String searchContent);
}
