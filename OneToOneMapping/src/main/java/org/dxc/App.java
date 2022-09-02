package org.dxc;

import java.util.Date;

import org.dxc.entity.Customers;
import org.dxc.entity.Txn;
import org.dxc.factorydesign.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Customers cust1 = new Customers();
		cust1.setAddress("San Jose, USA");
		cust1.setEmail("kim@abc.com");
		cust1.setName("kim");
		
		Customers cust2 = new Customers();
		cust2.setAddress("Elias St");
		cust2.setEmail("roy@abc.com");
		cust2.setName("roy");
		
    	Txn txn1 = new Txn();
		txn1.setDate(new Date());
		txn1.setTotal(100);
		
		Txn txn2 = new Txn();
		txn2.setDate(new Date());
		txn2.setTotal(2500);
		
		txn1.setCustomers(cust1);
		txn2.setCustomers(cust2);
		
		cust1.setTransaction(txn1);
		cust2.setTransaction(txn2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
		//Get Session
				sessionFactory = HibernateFactory.getSessionFactory();
				session = sessionFactory.getCurrentSession();
				System.out.println("Session created using annotations configuration");
				//start transaction
				tx = session.beginTransaction();
				//Save the Model object
				session.save(txn1);
				session.save(txn2);
				//Commit transaction
				tx.commit();
				}catch(Exception e){
					System.out.println("Exception occured. "+e.getMessage());
					e.printStackTrace();
				}finally{
					if(sessionFactory != null && !sessionFactory.isClosed()){
						System.out.println("Closing SessionFactory");
						sessionFactory.close();
					}
				}
    }
}
