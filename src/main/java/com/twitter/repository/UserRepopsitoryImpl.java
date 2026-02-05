package com.twitter.repository;

import com.twitter.base.repository.BaseRepositoryImpl;
import com.twitter.entity.User;

import javax.persistence.EntityManager;

public class UserRepopsitoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {

    public UserRepopsitoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User loginToSystem(String username, String password) {
        return entityManager.createQuery("from "+getEntityClass().getSimpleName()+" " +
                "where username=:username and password=:password",getEntityClass())
                .setParameter("username",username).setParameter("password",password).getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("from "+getEntityClass().getSimpleName()+
                " where username=:username",getEntityClass()).setParameter("username",username).getSingleResult();
    }
}
