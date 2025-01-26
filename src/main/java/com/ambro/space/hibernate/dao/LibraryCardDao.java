package com.ambro.space.hibernate.dao;

import com.ambro.space.hibernate.enitity.LibraryCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class LibraryCardDao implements DAO<LibraryCard> {
    public static final Logger logger = LogManager.getLogger(LibraryCardDao.class);
    SessionFactory factory;

    public LibraryCardDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public LibraryCard add(LibraryCard item) {

        return null;
    }

    @Override
    public LibraryCard get(String item) {
        return null;
    }

    @Override
    public LibraryCard update(LibraryCard item) {
        return null;
    }

    @Override
    public LibraryCard delete(LibraryCard item) {
        return null;
    }
}
