package com.example.demojap3;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import java.io.Serializable;

public class SimpleMyRepository<T, ID extends Serializable>
        extends QuerydslJpaRepository<T, ID> implements  MyRepository<T, ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation,
                              EntityManager entityManager) {
        super((JpaEntityInformation<T, ID>) entityInformation, entityManager);
        this.entityManager=entityManager;
    }

    @Override
    public boolean contains(T entity){
        return entityManager.contains(entity);
    }

}





