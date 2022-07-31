package cardinalities.onetomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
		LaptopOneToMany lap=new LaptopOneToMany();
		lap.setLid(1);
		lap.setLname("HP");
		LaptopOneToMany lap1=new LaptopOneToMany();
		lap1.setLid(2);
		lap1.setLname("DELL");
		StudentOneToMany s=new StudentOneToMany();
		s.getLap().add(lap);
		s.getLap().add(lap1);
		s.setName("shubh");
		s.setRoll_no(1);
		Configuration configuration=new Configuration().configure().addAnnotatedClass(StudentOneToMany.class).addAnnotatedClass(LaptopOneToMany.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(lap);
		session.save(lap1);
		session.save(s);
		t.commit();
		System.out.println(lap);
		System.out.println(lap1);
	System.out.print(s);
	}

}
