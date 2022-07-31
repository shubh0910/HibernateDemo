package student.insert;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateStudent {

	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class);
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf=configuration.buildSessionFactory(ssrb.build());
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		int ch;
		Student s=null;
		do {
		System.out.println("1.Insert\t2.Delete\t3.Update\t4.Select\t5.Exit");
		System.out.print("enter your choice");
		ch=ss.nextInt();
		switch(ch) {
		case 1:
			System.out.print("enter name :- ");
			String name=ss.next();
			System.out.print("enter class :- ");
			String class1=ss.next();
			System.out.print("enter sem :- ");
			String sem=ss.next();
			System.out.print("enter mobile no :- ");
			String mno=ss.next();
			System.out.print("enter city :- ");
			String city=ss.next();
		s= new Student(name,class1,sem,mno,city);
		session.save(s);
		t.commit();
		break;
		
		case 2:
			System.out.print("enter student roll no :- ");
			int index=ss.nextInt();
			s=session.get(Student.class,index);
			session.delete(s);
			t.commit();
			break;
		case 3:
			System.out.print("Enter roll_no");
			int rno =ss.nextInt();
			s=session.get(Student.class,rno);
			int c;
			do {
				System.out.println("1.Name\t2.Class\t3.Sem\t4.Mobile No\t5.City\t6.Exit");
				System.out.print("enter your choice");
				c=ss.nextInt();	
				switch(c) {
			case 1:
				System.out.print("enter name :- ");
			 name=ss.next();
			 s.setName(name);
			break;
			case 2: 
				System.out.print("enter class :- ");
			 class1=ss.next();
			 s.setClass1(class1);
			 break;
			case 3:
			System.out.print("enter sem :- ");
			 sem=ss.next();
			 s.setSem(sem);
			 break;
			case 4:
			System.out.print("enter mobile no :- ");
			mno=ss.next();
			s.setMobile_no(mno);
			break;
			case 5:
			System.out.print("enter city :- ");
			city=ss.next();
			s.setCity(city);
			break;
			}
			}while(c!=6);
			session.save(s);
			t.commit();
			break;
		case 4:
			Query<Student> query = session.createQuery("from Student");
			List<Student> students= query.list();
			int i=0;
			System.out.println("Roll_no\tName\tClass\tSem\tMobile_no\tCity");
			while(i<students.size()) {
				 s=students.get(i);
				 System.out.println(s);
				// System.out.println(s.getRoll_no()+"\t"+s.getName()+"\t"+s.getClass1()+"\t"+s.getSem()+"\t"+s.getMobile_no()+"\t"+s.getCity());
			i++;
			}
			t.commit();
			break;
		case 5:
			t.commit();
			System.out.println("Thanks for visit!");
			break;
		}
		
		t.begin();
		}while(ch!=5);
			
		session.close();
		ss.close();
	}

}