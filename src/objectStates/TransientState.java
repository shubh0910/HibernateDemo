package objectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TransientState {

	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(ObjectTable.class);
		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
		SessionFactory sf=cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		s.beginTransaction();
		
		ObjectTable ot=new ObjectTable();
		ot.setName("mohan");
		ot.setCity("unjha");
		//Object is in transient state until it is not stored
		
		s.save(ot);
		//Object is in persistent state when it is stored in session or anywhere 
		
		//Object detached
		//s.detach(ot);
		
		//Object removed
		//s.remove(ot);
		
		ot.setName("ram");
		s.getTransaction().commit();
		s.close();
	}

}