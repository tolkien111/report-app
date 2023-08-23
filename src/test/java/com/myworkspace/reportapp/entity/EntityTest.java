package com.myworkspace.reportapp.entity;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class EntityTest {

    @Autowired
    protected EntityManager em;

    protected void persistObject(Object entity){
        em.persist(entity);
        em.flush();
        em.clear();
    }

}
