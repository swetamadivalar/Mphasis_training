package com.test;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLTest {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		//Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		//String hql="select o.o_name,o_quantity,o_price from Order o";
		String hql1="delete from Order where id=:id";
		Query query=session.createQuery(hql1);
		query.setParameter("id",1);
		query.executeUpdate();
		t.commit();
		String hql="select from Order";
		Query<Order> q=session.createQuery(hql,Order.class);
		List<Order> list=q.getResultList();
		list.forEach(dt->System.out.println(dt.getId()+" "+dt.getO_name()+" "+dt.getO_quantity()+" "+dt.getO_price()));
		
	}
}
