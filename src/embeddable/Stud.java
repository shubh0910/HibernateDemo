package embeddable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Transient;
@Entity
//@Entity(name="stud") create table as per given name  
//@Table(name="stud") 
public class Stud {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roll_no;
	
	private Name sname;
	private String class1;
	//@Transient
	private String sem;
	private String mobile_no;
	private String city;

	public Stud() {}
	
	public Name getSname() {
		return sname;
	}

	public void setSname(Name sname) {
		this.sname = sname;
	}

	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public Stud(Name name, String class1, String sem, String mobile_no, String city) {
		super();
		this.sname =name;
		this.class1 = class1;
		this.sem = sem;
		this.mobile_no = mobile_no;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", " + getSname() + ", class1=" + class1 
				+ ", " + "sem=" + sem + ", mobile_no=" + mobile_no + ", city=" + city + "]";
	}
}
