package cardinalities.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class LaptopManyToOne {
	@Id
	private int lid;
	private String lname;
	@javax.persistence.ManyToOne
	private StudentManyToOne student;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public StudentManyToOne getStudent() {
		return student;
	}
	public void setStudent(StudentManyToOne student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "LaptopManyToOne [lid=" + lid + ", lname=" + lname + ", student=" + student + "]";
	}
	
}
