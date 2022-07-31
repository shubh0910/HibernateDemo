package fetch;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetrieveData {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(FetchLaptop.class).addAnnotatedClass(FetchStudent.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t= s.beginTransaction();
		
		FetchStudent s4=s.get(FetchStudent.class, 2);
		System.out.println(s4);
		
		Collection<FetchLaptop> laptops=s4.getLap();
		for(FetchLaptop l : laptops) {
			System.out.println(l);
		}
		t.commit();
	}

}