package student.insert;
//alt + shift +r for changing name in current file and press it 2 times for changing it globally 
//import java.util.List;
import java.util.List;
import java.util.Scanner;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateQuery {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t;//=session.beginTransaction();
		Query q;
		Student st;
		int ch;
		do{
			t=session.beginTransaction();
			System.out.println("1.Insert\t2.Delete\t3.Update\t4.Select\t5.Exit");
			System.out.print("enter our choice :- ");
			ch=s.nextInt();
		switch(ch){
		
		case 1:
			System.out.print("enter name :- ");
			String name=s.next();
			System.out.print("enter class :- ");
			String class1=s.next();
			System.out.print("enter sem :- ");
			String sem=s.next();
			System.out.print("enter mobile no :- ");
			String mno=s.next();
			System.out.print("enter city :- ");
			String city=s.next();
			q=session.createSQLQuery("INSERT INTO Student ( name , class , sem , mobile_no , city ) VALUES ( :n , :cl , :s , :m , :ci )");
			q.setParameter("n", name);
			q.setParameter("cl", class1);
			q.setParameter("s", sem);
			q.setParameter("m", mno);
			q.setParameter("ci", city);
			q.executeUpdate();
			t.commit();
			break;
		case 2:
			System.out.print("enter roll_no :- ");
			int rn=s.nextInt();
			q=session.createQuery("DELETE FROM Student s where s.roll_no = :n ");
			q.setParameter("n",rn);
			q.executeUpdate();
			t.commit();
			break;
		case 3:
			System.out.print("Enter roll_no");
			int rno =s.nextInt();
			q=session.createQuery("from Student where roll_no=:rno");
			q.setParameter("rno",rno);
			//q.getResultList();
			Student stu= (Student) q.uniqueResult();
			System.out.println(stu);
			int c;
			
			do {
				System.out.println("1.Name\t2.Class\t3.Sem\t4.Mobile No\t5.City\t6.Exit");
				System.out.print("enter your choice");
				c=s.nextInt();	
			
				switch(c) {
				
				case 1:
					System.out.print("enter name :- ");
					name=s.next();
					stu.setName(name);
					break;
			
				
				case 2: 
					System.out.print("enter class :- ");
					class1=s.next();
					stu.setClass1(class1);
					break;
				
				case 3:
					System.out.print("enter sem :- ");
					sem=s.next();
					stu.setSem(sem);
					break;
					
				case 4:
					System.out.print("enter mobile no :- ");
					mno=s.next();
					stu.setMobile_no(mno);
					break;
				
				case 5:
					System.out.print("enter city :- ");
					city=s.next();
					stu.setCity(city);
					break;
			}
				
			}while(c!=6);
			
			t.commit();
			
			break;
		case 4:
			Query<Student> query = session.createQuery("from Student order by roll_no asc");
			List<Student> students= query.list();
			int i=0;
			System.out.println("Roll_no\tName\tClass\tSem\tMobile_no\tCity");
			while(i<students.size()) {
				 st=students.get(i);
				 System.out.println(st);
				// System.out.println(s.getRoll_no()+"\t"+s.getName()+"\t"+s.getClass1()+"\t"+s.getSem()+"\t"+s.getMobile_no()+"\t"+s.getCity());
			i++;
			}
			t.commit();
			break;
		case 5:
			t.commit();
			System.out.println("Thanks");
			break;
		}
		}while(ch!=5);
		
		
	/*	Query q=session.createQuery("from Student where roll_no =:roll_no");
		q.setInteger("roll_no",2);
	*/
	/*	Query p=session.createQuery("update Student set mobile_no =:mno where name =:name");
		p.setString("mno","123456789");
		p.setString("name", "shubh");
		p.executeUpdate();
		t.commit();
		*/
		/*
		Query p=session.createQuery("delete from Student where roll_no =:rno");
		p.setInteger("rno",10);
		p.executeUpdate();
		t.commit();
		*/
		/*
		Query<Student> q=session.createQuery("from Student where roll_no > 5 order by name desc");
//		q.setMaxResults(1);
		
		List<Student> list=q.list(); 
		Student s=null;//(Student) q.uniqueResult(); 
		int i=0;
		while(i<list.size()) {
			 s=list.get(i);
			 System.out.println(s.getRoll_no()+"\t"+s.getName()+"\t"+s.getClass1()+"\t"+s.getSem()+"\t"+s.getMobile_no()+"\t"+s.getCity());
		i++;
		}
		//session.save(s);
		t.commit();*/
		session.close();
		s.close();
	}
}