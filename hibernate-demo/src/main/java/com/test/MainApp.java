package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setName("Genereal Employee");
		
		FullTimeEmployee f=new FullTimeEmployee();
		f.setName("abc");
		f.setSalary(50000);
		
		PartTimeEmployee p=new PartTimeEmployee();
		p.setName("the");
		p.setHourlyRate(200);
		
		session.persist(emp);
		session.persist(f);
		session.persist(p);
		
		t.commit();
		
		System.out.println("Done.");
		
		session.close();
		sf.close();
		
	}
}
