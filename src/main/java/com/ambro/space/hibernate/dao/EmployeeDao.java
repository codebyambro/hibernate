package com.ambro.space.hibernate.dao;

import com.ambro.space.hibernate.enitity.Employee;
import com.ambro.space.hibernate.exception.RecordNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;

import java.util.List;


public class EmployeeDao {

    public static Logger logger = LogManager.getLogger(EmployeeDao.class);

    SessionFactory factory;
    public EmployeeDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Employee employee){

        try{
            Session session = factory.openSession();
            Transaction tnx = session.beginTransaction();

            session.save(employee);
            tnx.commit();
            session.close();
            logger.info("Employee details saved!!!");

        }catch (Exception e){
            logger.info(e.getStackTrace());
        }finally {
        }
    }

    public Employee getById(int id){
        Session session = null;
        Transaction tnx = null;
        try{
            session = factory.openSession();
            tnx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee!=null){
                logger.info("Employee details found :)");
                return employee;
            }else{
                throw new RecordNotFoundException("Employee details Not found");
            }

        }catch (Exception e){
            logger.info(e.getStackTrace());
        }finally {
            session.close();
        }
        return null;
    }

    public List<Employee> getEmployees(){
        Session session = null;
        Transaction tnx = null;
        try{
            session = factory.openSession();
            tnx = session.beginTransaction();
            List<Employee> employees= session.createQuery("from Employee", Employee.class).list();
            return employees;

        }catch (Exception e){
            logger.info(e.getStackTrace());
        }finally {
            session.close();
        }
        return null;
    }

    public Employee update(Employee emp){
        Session session = null;
        Transaction tnx = null;
        try{
            session = factory.openSession();
            tnx = session.beginTransaction();
            Employee employee = getById(emp.getId());
            if (employee!=null){

                employee.setName(emp.getName());
                employee.setEmail(emp.getEmail());
                tnx.commit();
                logger.info("Employee details updated :)");
                return employee;
            }else{
                throw new RecordNotFoundException("Employee details Not found :(");
            }

        }catch (Exception e){
            logger.info(e.getStackTrace());
        }finally {
            session.close();
        }
        return null;
    }

    public Employee deletedById(int id){
        Session session = null;
        Transaction tnx = null;
        try{
            session = factory.openSession();
            tnx = session.beginTransaction();
            Employee employee = getById(id);
            if (employee!=null){

                session.delete("Employee", employee);
                tnx.commit();
                logger.info("Employee details deleted :)");
                return employee;
            }else{
                throw new RecordNotFoundException("Employee details Not found :(");
            }

        }catch (Exception e){
            logger.info(e.getStackTrace());
        }finally {
            session.close();
        }
        return null;
    }

    public List<Employee> getEmployeeList(){
        StatelessSession session = null;
        Transaction tnx = null;
        try {
            session  = factory.openStatelessSession();
            tnx = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
            Root<Employee> root = query.from(Employee.class);
            query.select(root).where(cb.gt(root.get("salary"),20000));

            List<Employee> list = session.createQuery(query).getResultList();
            return list;

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

}
