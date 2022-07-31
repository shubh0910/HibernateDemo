package student.insert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roll_no;
	private String name;
	@Column(name="class")
	private String class1;
	//@Transient
	private String sem;
	private String mobile_no;
	private String city;

	public Student() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public Student(String name, String class1, String sem, String mobile_no, String city) {
		super();
		this.name = name;
		this.class1 = class1;
		this.sem = sem;
		this.mobile_no = mobile_no;
		this.city = city;
	}

	@Override
	public String toString() {
		return roll_no +"\t"+name + "\t" + class1 + "\t" + sem + "\t"+ mobile_no + "\t" + city ;
	//	return "Student [roll_no=" + roll_no + ", name=" + name + ", class1=" + class1 + ", sem=" + sem + ", mobile_no="
	//			+ mobile_no + ", city=" + city + "]";
	}

}
