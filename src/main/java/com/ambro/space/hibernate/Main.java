package com.ambro.space.hibernate;

import com.ambro.space.hibernate.config.HibernateConfig;
import com.ambro.space.hibernate.dao.AuthorDao;
import com.ambro.space.hibernate.enitity.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        AuthorDao dao = new AuthorDao(HibernateConfig.getSessionFactory());
        Author author = new Author(Long.parseLong("0"), "J.R.R. Tolkien", new Date(), new Date(), null, "John Ronald Reuel Tolkien was an English writer, poet, philologist, and academic best known as the author of the high fantasy works The Hobbit and The Lord of the Rings.");
       Author res = dao.add(author);
        System.out.println("Name : " + res.getName());
//       if(res != null) {logger.info(res.getName());} else {logger.info("res.getName()");};

    }

    static void print(Object data){
        System.out.println(data.toString());
    }

}
