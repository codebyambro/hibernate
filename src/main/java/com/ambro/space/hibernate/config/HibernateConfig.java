package com.ambro.space.hibernate.config;

import com.ambro.space.hibernate.enitity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Appendable.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return factory;
    }
    public static void closeSessionFactory(){
        factory.close();
    }

}
