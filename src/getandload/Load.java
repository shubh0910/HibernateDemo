package getandload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import objectStates.ObjectTable;

public class Load {

	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(ObjectTable.class);
		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
		SessionFactory sf=cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		s.beginTransaction();
		/*
		ObjectTable ot=new ObjectTable();
		ot.setName("mohan");
		ot.setCity("unjha");
		s.save(ot);
		*/
		ObjectTable o=s.load(ObjectTable.class,1);
		//gives Proxy object
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(o);
		s.getTransaction().commit();
		s.close();
	}

}
