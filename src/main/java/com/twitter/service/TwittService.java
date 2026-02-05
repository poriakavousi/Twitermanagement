package com.twitter.service;

import com.twitter.base.service.BaseService;
import com.twitter.entity.Twitt;
import com.twitter.entity.User;

import java.util.List;

public interface TwittService extends BaseService<Twitt,Long> {
    List<Twitt> findByContent(String searchContent);
}
