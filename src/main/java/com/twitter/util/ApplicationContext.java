package com.twitter.util;

import com.twitter.repository.*;
import com.twitter.service.*;

import javax.persistence.EntityManager;


public class ApplicationContext {
    private static final EntityManager entityManager;
    private static final UserService userService;
    private static final UserRepository repository;
    private static final TwittService twittService;
    private static final TwittRepopsitory twittRepository;
    private static final MentionService mentionService;
    private static final MentioRepository mentioRepository;

    static {
        entityManager=HibernateUtil.getEntityManagerFactory().createEntityManager();
        repository=new UserRepopsitoryImpl(entityManager);
        userService =new UserServiceImpl(repository);
        twittRepository=new TwittRepositoryImpl(entityManager);
        twittService=new TwittServiceImpl(twittRepository);
        mentioRepository=new MentionRepositoryImpl(entityManager);
        mentionService=new MentionServiceImpl(mentioRepository);

    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static UserRepository getRepository() {
        return repository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static TwittRepopsitory getTwittRepository() {
        return twittRepository;
    }

    public static TwittService getTwittService() {
        return twittService;
    }

    public static MentionService getMentionService() {
        return mentionService;
    }

    public static MentioRepository getMentioRepository() {
        return mentioRepository;
    }
}
