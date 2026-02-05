package com.twitter.base.repository;
import com.twitter.base.domain.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl <E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {
    protected EntityManager entityManager;
    public abstract Class<E> getEntityClass();
    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public E findById(ID id) {
        return entityManager.createQuery("from "+getEntityClass().
                getSimpleName()+
                " where id=:id",getEntityClass()).setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<E> findAll() {
        return entityManager.
                createQuery("from "+getEntityClass().
                        getSimpleName(),getEntityClass()).getResultList();
    }

    @Override
    public boolean isExist(ID id) {

        return entityManager.createQuery("from "+getEntityClass().getSimpleName()+
                        " where id=:id",
                getEntityClass()).setParameter("id",id).getResultList().size()==1L;
    }

    @Override
    public E save(E e) {
        entityManager.getTransaction().begin();
       if(e.getId()==null){
           entityManager.persist(e);//ذخیره کردن
       }
       else{
           entityManager.merge(e);//بروزرسانی
       }
       entityManager.getTransaction().commit();
       return e;
    }

    @Override
    public void delete(ID id) {
        E findedEntity = findById(id);
        entityManager.remove(findedEntity);//حذف عنصر

    }

    @Override
    public Long countAll() {
        return entityManager.
                createQuery("select count(*) from"+getEntityClass().getSimpleName()
                        ,Long.class).getSingleResult();
    }
}
