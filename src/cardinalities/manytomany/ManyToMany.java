package cardinalities.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManyToMany {

	public static void main(String[] args) {
/*		LaptopManyToMany lap=new LaptopManyToMany();
		lap.setLid(1);
		lap.setLname("HP");
		
		LaptopManyToMany lap1=new LaptopManyToMany();
		lap1.setLid(2);
		lap1.setLname("DELL");
		
		
		LaptopManyToMany lap2=new LaptopManyToMany();
		lap2.setLid(3);
		lap2.setLname("MacBook");
		
		StudentManyToMany s=new StudentManyToMany();
		s.getLap().add(lap);
		s.getLap().add(lap1);
		s.setName("shubh");
		s.setRoll_no(1);
		StudentManyToMany s1=new StudentManyToMany();
		s1.getLap().add(lap2);
		s1.setName("dev");
		s1.setRoll_no(2);
		lap.getStudent().add(s1);
		lap.getStudent().add(s);
		lap1.getStudent().add(s);
		lap2.getStudent().add(s1);
	*/	
		Configuration configuration=new Configuration().configure().addAnnotatedClass(StudentManyToMany.class).addAnnotatedClass(LaptopManyToMany.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		/*
	 	session.save(lap);
		session.save(lap1);
		session.save(lap2);
		session.save(s);
		session.save(s1);
		*/
		StudentManyToMany s=session.get(StudentManyToMany.class, 2);
		System.out.println(s);
		
		t.commit();
	}

}
