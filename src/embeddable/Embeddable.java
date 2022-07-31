package embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Embeddable {
	public static void main(String args[]) {
		Name n=new Name();
		n.setFname("shubhkumar");
		n.setMname("sureshbhai");
		n.setSurname("patel");
		Stud s=new Stud();
		s.setSname(n);
		s.setCity("baroda");
		s.setClass1("ME");
		s.setMobile_no("328974878");
		s.setSem("10");
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Stud.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.save(s);
		t.commit();
		System.out.print(s);
	}
}
