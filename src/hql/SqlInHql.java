package hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SqlInHql {

	public static void main(String[] args) {
		
		//Native Queries
		Configuration cfg=new Configuration().configure().addAnnotatedClass(StudentHql.class);
		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
		SessionFactory sf=cfg.buildSessionFactory(sr);
		Session s=sf.openSession();
		s.beginTransaction();
		/*
		SQLQuery sq=s.createSQLQuery("select * from StudentHql");
		sq.addEntity(StudentHql.class);
		List<StudentHql> res=sq.list();
		for(StudentHql sh:res) {
			System.out.println(sh);
		}
		*/
		SQLQuery sq=s.createSQLQuery("select name,city from StudentHql");
		sq.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<StudentHql> res=sq.list();
		for(Object sh:res) {
			Map m=(Map)sh;
			System.out.println(m.get("name")+"\t"+m.get("city"));
		}
		s.getTransaction().commit();
	}

}
