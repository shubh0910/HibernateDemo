package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class SelectHql {

	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure().addAnnotatedClass(StudentHql.class);
		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
		SessionFactory sf=cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		s.beginTransaction();
		/*StudentHql stud1=new StudentHql();
		stud1.setRoll_no(1);
		stud1.setName("shubh");
		stud1.setCity("unjha");
		StudentHql stud2=new StudentHql();
		stud2.setRoll_no(2);
		stud2.setName("dev");
		stud2.setCity("unjha");
		StudentHql stud3=new StudentHql();
		stud3.setRoll_no(3);
		stud3.setName("marmik");
		stud3.setCity("unjha");
		StudentHql stud4=new StudentHql();
		stud4.setRoll_no(4);
		stud4.setName("rushi");
		stud4.setCity("unjha");
		s.save(stud1);
		s.save(stud2);
		s.save(stud3);
		s.save(stud4);
		*/
		/*Query q=s.createQuery("from StudentHql where roll_no > 2 order by name desc");
		List<StudentHql> re=q.list();
		for(StudentHql ss:re) {
			System.out.println(ss);
		}*/
		/*//for 1 Object
		Query q=s.createQuery("select roll_no,name,city from StudentHql where roll_no =2");
		Object[] stud=(Object[])q.uniqueResult();
		for(Object o:stud) {
			System.out.println(o);
		}*/
		Query q=s.createQuery("select roll_no,name,city from StudentHql where roll_no >2");
		List<Object[]> stud=(List<Object[]>)q.list();
		for(Object[] o:stud) {
			System.out.println(o[0] +"\t" +o[1]+"\t" + o[2]);
		}
		s.getTransaction().commit();
	}

}
