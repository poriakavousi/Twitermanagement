package com.twitter.service;

import com.twitter.base.service.BaseServiceImpl;
import com.twitter.entity.Twitt;
import com.twitter.entity.User;
import com.twitter.repository.TwittRepopsitory;
import com.twitter.repository.UserRepository;

import java.util.List;

public class TwittServiceImpl extends BaseServiceImpl<Twitt,Long, TwittRepopsitory> implements TwittService{
    public TwittServiceImpl(TwittRepopsitory repository) {
        super(repository);
    }

    @Override
    public List<Twitt> findByContent(String searchContent) {
        return repository.findByContent(searchContent);
    }
}
