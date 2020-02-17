package com.rkb.hibernate;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rkb.Address;
import com.rkb.LoginCredentials;
import com.rkb.UserDetails;
import com.rkb.UserWithListOfAddress;
import com.rkb.inheritance.FourWheelers;
import com.rkb.inheritance.TwoWheelers;
import com.rkb.inheritance.Vechile;

public class Test {

	public static void main(String[] args) {
		
		Address addr = new Address();
		addr.setCity("Banepa");
		addr.setState("kavre");
		addr.setStreet("Naladobato");
		addr.setZipcode(1234);
		
		Address addr2 = new Address();
		addr2.setCity("ny");
		addr2.setState("ny");
		addr2.setStreet("wyckoff");
		addr2.setZipcode(11237);
		
		LoginCredentials user = new LoginCredentials();
		user.setFname("ram");
		user.setLname("bhattarai");
		user.setUsername("ramkb");
		user.setEmail("ramkb466@gmail.com");
		user.setPassword("hiall");
	UserDetails ud = new UserDetails();
	ud.setUser(user);
	ud.setActive(new Boolean(true));
	ud.setHomeAddress(addr);
	ud.setOfficeAddress(addr2);
	ud.setDescription("practise");
	ud.setDate(LocalDateTime.now());
	
	UserWithListOfAddress u = new UserWithListOfAddress();
	u.setUsername("ramkb");
	u.getAddresses().add(addr);
	u.getAddresses().add(addr2);
	
	Vechile v = new Vechile();
	v.setName("testVechile");
	
	TwoWheelers tv = new TwoWheelers();
	tv.setType("bike");
	tv.setName("honda");
	
	FourWheelers fv = new FourWheelers();
	fv.setType("car");
	fv.setName("apache");
	
	
	
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
		s.close();
		
		 s = sf.openSession();
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
			s.close();
			
			u = null;
			 s = sf.openSession();
			s.beginTransaction();
			u = s.get(UserWithListOfAddress.class, 1);
			System.out.println("UserWithListOfAddress retrieved is "+ u);
			s.close();
			
			s = sf.openSession();
			s.beginTransaction();
			s.save(v);
			s.getTransaction().commit();
			s.close();
			
			s = sf.openSession();
			s.beginTransaction();
			s.save(tv);
			s.getTransaction().commit();
			s.close();
			
			s = sf.openSession();
			s.beginTransaction();
			s.save(fv);
			s.getTransaction().commit();
			s.close();
		
		
	}

}
