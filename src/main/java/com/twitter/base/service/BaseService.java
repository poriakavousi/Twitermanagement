package com.twitter.base.service;

import com.twitter.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {
   E findById(ID id);
   List<E> findAll();
   boolean isExist(ID id);
   E save(E e);
   void delete(ID id);
   Long countAll();
}
