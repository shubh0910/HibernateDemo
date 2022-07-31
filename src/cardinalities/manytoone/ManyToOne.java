package cardinalities.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManyToOne {

	public static void main(String[] args) {
		StudentManyToOne s=new StudentManyToOne();
		//s.getLap().add(lap);
		//s.getLap().add(lap1);
		s.setName("shubh");
		s.setRoll_no(1);
		StudentManyToOne s1=new StudentManyToOne();
		//s1.getLap().add(lap2);
		s1.setName("dev");
		s1.setRoll_no(2);
		LaptopManyToOne lap=new LaptopManyToOne();
		lap.setLid(1);
		lap.setLname("HP");
		lap.setStudent(s);
		LaptopManyToOne lap1=new LaptopManyToOne();
		lap1.setLid(2);
		lap1.setLname("DELL");
		lap1.setStudent(s1);
		
		LaptopManyToOne lap2=new LaptopManyToOne();
		lap2.setLid(3);
		lap2.setLname("MacBook");
		lap2.setStudent(s);
		
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(StudentManyToOne.class).addAnnotatedClass(LaptopManyToOne.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(lap);
		session.save(lap1);
		session.save(lap2);
		session.save(s);
		session.save(s1);
		t.commit();
	//	System.out.println(lap);
	//	System.out.println(lap1);
	//System.out.print(s);

	}

}
