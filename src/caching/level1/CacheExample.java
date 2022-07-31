package caching.level1;

import javax.persistence.Cacheable;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
//import javax.persistence.Transient;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class CacheExample {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roll_no;
//	@Column(name="name",length=20,nullable=true,unique=true)
	private String name;
	private String class1;
	//@Transient
	private String sem;
	private String mobile_no;
	private String city;

	public CacheExample() {}
	
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

	public CacheExample(String name, String class1, String sem, String mobile_no, String city) {
		super();
		this.name = name;
		this.class1 = class1;
		this.sem = sem;
		this.mobile_no = mobile_no;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", class1=" + class1 + ", sem=" + sem + ", mobile_no="
				+ mobile_no + ", city=" + city + "]";
	}
}
