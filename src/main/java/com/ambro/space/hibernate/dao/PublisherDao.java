package com.ambro.space.hibernate.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class PublisherDao {
    public static final Logger logger = LogManager.getLogger(PublisherDao.class);
    SessionFactory factory;

    PublisherDao(SessionFactory factory) {
        this.factory = factory;
    }

//    public void addPublisher

}
