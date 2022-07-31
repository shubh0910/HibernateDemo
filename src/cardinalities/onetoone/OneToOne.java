package cardinalities.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {
		LaptopOneToOne lap=new LaptopOneToOne();
		lap.setLid(1);
		lap.setLname("HP");
		StudentOneToOne s=new StudentOneToOne();
		s.setLap(lap);
		s.setName("shubh");
		s.setRoll_no(1);
		Configuration configuration=new Configuration().configure().addAnnotatedClass(StudentOneToOne.class).addAnnotatedClass(LaptopOneToOne.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(lap);
		session.save(s);
		t.commit();
		System.out.println(lap);
	System.out.print(s);
	}

}
