package com.codegym.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class BaseRepository {

    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
}
