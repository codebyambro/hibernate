package com.ambro.space.hibernate.dao;

import com.ambro.space.hibernate.enitity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

public class AuthorDao implements DAO<Author> {
    SessionFactory factory;
    public static final Logger logger = LogManager.getLogger(AuthorDao.class);

    public AuthorDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void addAuthor(Author author){
        StatelessSession session = factory.openStatelessSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.insert(author);
            logger.info("Author details saved");

            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
            logger.info("Session closed");
        }
    }

    @Override
    public Author add(Author item) {
        Session session = factory.openSession();

        try{
            Transaction transaction = session.beginTransaction();
            Long result = (Long) session.save(item);
            logger.info( item.getClass().getSimpleName() + " details saved : " + result);

            transaction.commit();
            return item;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
            logger.info("Session closed");
//            return result;
        }
    }

    @Override
    public Author get(String item) {
        return null;
    }

    @Override
    public Author update(Author item) {
        return null;
    }

    @Override
    public Author delete(Author item) {
        return null;
    }
}
