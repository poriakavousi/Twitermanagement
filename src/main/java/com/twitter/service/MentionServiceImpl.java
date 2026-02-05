package com.twitter.service;

import com.twitter.base.service.BaseServiceImpl;
import com.twitter.entity.Mention;
import com.twitter.entity.Twitt;
import com.twitter.repository.MentioRepository;
import com.twitter.repository.TwittRepopsitory;

public class MentionServiceImpl extends BaseServiceImpl<Mention,Long, MentioRepository> implements MentionService{
    public MentionServiceImpl(MentioRepository repository) {
        super(repository);
    }
}
