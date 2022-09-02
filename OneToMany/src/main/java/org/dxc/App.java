package org.dxc;

import java.util.ArrayList;

import org.dxc.entity.Answer;
import org.dxc.entity.Question;
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
	private static SessionFactory factory;
    public static void main(String[] args) {
    	try {
        	// create factory object
        	factory = new Configuration().configure("/resource/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
        	System.err.println("Failed to create session instance.");
        	throw new ExceptionInInitializerError(e);
        }
    	
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Answer ans1 = new Answer();
    	ans1.setAnswerName("Java is a programming language");
    	ans1.setPostedBy("Jun Hao");
    	
    	Answer ans2 = new Answer();
    	ans2.setAnswerName("Java is a platform");
    	ans2.setPostedBy("Brian");
    	
    	Answer ans3 = new Answer();
    	ans3.setAnswerName("Servlet is an interface");
    	ans3.setPostedBy("Haikal");
    	
    	Answer ans4 = new Answer();
    	ans4.setAnswerName("JDBC is an API");
    	ans4.setPostedBy("Damien");
    	
    	ArrayList<Answer> list1 = new ArrayList<Answer>();
    	list1.add(ans1);
    	list1.add(ans2);
    	
    	ArrayList<Answer> list2 = new ArrayList<Answer>();
    	list2.add(ans3);
    	list2.add(ans4);
    	
    	Question question1 = new Question();
    	question1.setQname("What is Java?");
    	question1.setAnswer(list1);
    	
    	Question question2 = new Question();
    	question2.setQname("What is JDBC?");
    	question2.setAnswer(list2);
    	
    	session.persist(question1);
    	session.persist(question2);
    	
    	tx.commit();
    	session.close();
    	System.out.println("Success");
    }
}
