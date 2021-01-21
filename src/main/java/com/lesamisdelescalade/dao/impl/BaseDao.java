package com.lesamisdelescalade.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public abstract class BaseDao<T extends Serializable> {
    protected static final Logger LOGGER = LogManager.getLogger(BaseDao.class);
    protected Class<T> modelClass;
    protected EntityManager em;

    public void setmodelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("lesamisdelescalade");
    }

    public void initEntityManager(){
        em = getEntityManagerFactory().createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    public void createOrUpdate(T obj) {
        EntityTransaction tx = this.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
    }

    public void delete(T obj) {
        EntityTransaction tx = this.getTransaction();
        tx.begin();
        em.remove(obj);
        tx.commit();
    }

    public T getById(Integer id) {
        return em.find(modelClass, id);
    }

    @SuppressWarnings("unchecked")
	public List<T> getAll() {
        return em.createQuery("from " + modelClass.getName()).getResultList();
    }
}
