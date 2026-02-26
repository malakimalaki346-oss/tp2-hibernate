package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public abstract class AbstractCrudService<T, ID> implements CrudService<T, ID> {

    protected static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gestionPU");

    protected EntityManager em = emf.createEntityManager();

    private Class<T> entityClass;

    public AbstractCrudService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        T updatedEntity = em.merge(entity);
        em.getTransaction().commit();
        return updatedEntity;
    }

    @Override
    public void delete(ID id) {
        T entity = findById(id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}