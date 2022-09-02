package org.dxc;

import java.util.HashSet;
import java.util.Set;

import org.dxc.entity.Employee;
import org.dxc.entity.Project;
import org.dxc.factorydesign.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Project p1 = new Project();
    	p1.setProjectName("Network Project");
    	
    	Project p2 = new Project();
    	p2.setProjectName("Database Migration");
    	
    	Set<Project> proj = new HashSet<Project>();
    	proj.add(p1);
    	proj.add(p2);
    	
    	Employee emp1 = new Employee();
    	emp1.setEmpFirstName("Danny");
    	emp1.setEmpLastName("Sim");
    	
    	Employee emp2 = new Employee();
    	emp2.setEmpFirstName("Keith");
    	emp2.setEmpLastName("Leong");
    	
    	Set<Employee> employees = new HashSet<Employee>();
    	employees.add(emp1);
    	employees.add(emp2);
    	
    	emp1.setProjects(proj);
    	emp2.setProjects(proj);
    	
    	SessionFactory sessionFactory = null;
    	Transaction tx = null;
    	Session session = null;
		try{
		sessionFactory = HibernateFactory.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
    }
}
