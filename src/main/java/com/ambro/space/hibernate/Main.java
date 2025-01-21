package com.ambro.space.hibernate;
import com.ambro.space.hibernate.config.HibernateConfig;
import com.ambro.space.hibernate.dao.EmployeeDao;
import com.ambro.space.hibernate.enitity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDao(HibernateConfig.getSessionFactory());
        try{
            List<Employee> list = dao.getEmployees();
            for(Employee emp: list){
                print(emp.getName()+ " " + emp.getSalary());
            }
        }catch (Exception e){
            log.info(e.getStackTrace());
        }

    }

    static void print(String str) {
        System.out.println(str);
    }
}