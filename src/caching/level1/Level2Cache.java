package caching.level1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Level2Cache {

	public static void main(String[] args) {
		CacheExample stud=null;
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(CacheExample.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory sf=cfg.buildSessionFactory(sr.build());
		
		//second level cache
	  	Session s1=sf.openSession();
		s1.beginTransaction();
		stud=(CacheExample)s1.get(CacheExample.class, 1);
		System.out.println(stud);
		s1.getTransaction().commit();
		s1.close();
		Session s2=sf.openSession();
		s2.beginTransaction();
		stud=(CacheExample)s2.get(CacheExample.class, 1);
		System.out.println(stud);
		s2.getTransaction().commit();
		s2.close();

	}

}
