package com.twitter.base.service;
import com.twitter.base.domain.BaseEntity;
import com.twitter.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
public class BaseServiceImpl <E extends BaseEntity<ID>,
        ID extends Serializable ,R extends BaseRepository<E,ID>> implements BaseService<E, ID>{
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean isExist(ID id) {
        return repository.isExist(id);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public void delete(ID id) {
repository.delete(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}
