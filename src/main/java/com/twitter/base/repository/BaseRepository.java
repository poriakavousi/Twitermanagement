package com.twitter.base.repository;

import com.twitter.base.domain.BaseEntity;
import com.twitter.base.service.BaseService;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository <E extends BaseEntity<ID>,
        ID extends Serializable> extends BaseService<E,ID> {
    EntityManager getEntityManager();
    E findById(ID id);
    List<E> findAll();
    boolean isExist(ID id);
    E save(E e);
    void delete(ID id);
    Long countAll();

}
