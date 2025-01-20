package com.ambro.space.hibernate;
import com.ambro.space.hibernate.enitity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        configuration.addAnnotatedClass(Employee.class);

        Employee emp = new Employee(1,"Alan", "alan@gmail.com");

        Session session = factory.openSession();
        Transaction tnx = session.getTransaction();

        session.save(emp);

        tnx.commit();

        session.close();

    }

    static void print(String str) {
        System.out.println(str);
    }
}