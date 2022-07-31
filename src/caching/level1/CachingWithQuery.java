package caching.level1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CachingWithQuery {

	public static void main(String[] args) {
CacheExample stud=null;
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(CacheExample.class);
		StandardServiceRegistryBuilder sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory sf=cfg.buildSessionFactory(sr.build());
		//caching with query
		Session s1=sf.openSession();
		s1.beginTransaction();
		Query q1=s1.createQuery("from CacheExample where roll_no = 1");
		q1.setCacheable(true);
		stud=(CacheExample)q1.uniqueResult();
		System.out.println(stud);
		s1.getTransaction().commit();
		s1.close();
		Session s2=sf.openSession();
		s2.beginTransaction();
		Query q2=s2.createQuery("from CacheExample where roll_no = 1");
		q2.setCacheable(true);
		stud=(CacheExample)q2.uniqueResult();
		System.out.println(stud);
		s2.getTransaction().commit();
		s2.close();
	}

}
