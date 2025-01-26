package com.ambro.space.hibernate.dao;

import com.ambro.space.hibernate.enitity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDao implements DAO<Book> {
    public static final Logger logger = LogManager.getLogger(BookDao.class);

    SessionFactory factory;

    public BookDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Book add(Book item) {
        Session session = factory.openSession();
        try{
            Transaction transaction = session.beginTransaction();

            Object result = session.save(item);


            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
            return null;
        }

    }

    @Override
    public Book get(String item) {
        return null;
    }

    @Override
    public Book update(Book item) {
        return null;
    }

    @Override
    public Book delete(Book item) {
        return null;
    }
}
