package com.rkb.hibernate;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rkb.Address;
import com.rkb.UserDetails;

public class Test {

	public static void main(String[] args) {
		
		Address addr = new Address();
		addr.setCity("Banepa");
		addr.setState("kavre");
		addr.setStreet("Naladobato");
		addr.setZipcode(1234);
	UserDetails ud = new UserDetails();
	ud.setUsername("test1");
	ud.setActive(new Boolean(true));
	ud.setAddress(addr);
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
