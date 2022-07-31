package fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {

	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(FetchStudent.class).addAnnotatedClass(FetchLaptop.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t= s.beginTransaction();
		FetchLaptop l1=new FetchLaptop();
		l1.setBrand("HP");
		l1.setLid(1);
		l1.setPrice(10000);
		FetchLaptop l2=new FetchLaptop();
		l2.setBrand("DELL");
		l2.setLid(2);
		l2.setPrice(10000);
		FetchLaptop l3=new FetchLaptop();
		l3.setBrand("MICROSOFT");
		l3.setLid(3);
		l3.setPrice(10000);
		
		FetchStudent s1=new FetchStudent();
		s1.getLap().add(l1);
		s1.setName("shubh");
		s1.setSid(1);
		l1.setStudent(s1);
		FetchStudent s2=new FetchStudent();
		s2.getLap().add(l2);
		s2.getLap().add(l3);
		s2.getLap().add(l1);
		s2.setName("dev");
		s2.setSid(2);
		
		l1.setStudent(s1);
		l2.setStudent(s2);
		l3.setStudent(s2);
		s.save(l1);
		s.save(l2);
		s.save(l3);
		
		s.save(s1);
		s.save(s2);
		t.commit();
	}

}
