package com.twitter.repository;

import com.twitter.base.repository.BaseRepositoryImpl;
import com.twitter.entity.Mention;
import com.twitter.entity.Twitt;

import javax.persistence.EntityManager;

public class MentionRepositoryImpl extends BaseRepositoryImpl<Mention,Long> implements MentioRepository{
    public MentionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Mention> getEntityClass() {
        return Mention.class;
    }
}
