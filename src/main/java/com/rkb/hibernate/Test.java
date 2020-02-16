package com.rkb.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rkb.UserDetails;

public class Test {

	public static void main(String[] args) {
	UserDetails ud = new UserDetails();
	ud.setId(1);
	ud.setUsername("test1");
	
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(ud);
		s.getTransaction().commit();
	}

}
