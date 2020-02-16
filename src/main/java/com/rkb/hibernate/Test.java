package com.rkb.hibernate;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rkb.UserDetails;

public class Test {

	public static void main(String[] args) {
	UserDetails ud = new UserDetails();
	ud.setId(1);
	ud.setUsername("test1");
	ud.setActive(new Boolean(true));
	ud.setAddress("Nepal");
	ud.setDescription("practise");
	ud.setDate(LocalDateTime.now());
	
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(ud);
		s.getTransaction().commit();
		s.close();
		
		ud = null;
		 s = sf.openSession();
		s.beginTransaction();
		ud = s.get(UserDetails.class, 1);
		System.out.println("User retrieved is "+ ud);
		
		
	}

}
