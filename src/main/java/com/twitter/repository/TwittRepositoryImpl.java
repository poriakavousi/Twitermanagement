package com.twitter.repository;

import com.twitter.base.repository.BaseRepositoryImpl;
import com.twitter.entity.Twitt;
import com.twitter.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class TwittRepositoryImpl extends BaseRepositoryImpl<Twitt,Long> implements TwittRepopsitory{
    public TwittRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Twitt> getEntityClass() {
        return Twitt.class;
    }

    @Override
    public List<Twitt> findByContent(String searchContent) {
        return entityManager.createQuery("from "+getEntityClass().getSimpleName()+
                " where twittContent like :searchContent",getEntityClass())
                .setParameter("searchContent","%"+searchContent+"%").getResultList();
    }
}
