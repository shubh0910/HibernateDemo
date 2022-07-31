package cardinalities.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LaptopManyToMany {
	@Id
	private int lid;
	private String lname;
	@javax.persistence.ManyToMany
	private List<StudentManyToMany> student=new ArrayList<StudentManyToMany>();
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
	public List<StudentManyToMany> getStudent() {
		return student;
	}
	public void setStudent(List<StudentManyToMany> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Student [lid=" + lid + ", lname=" + lname + "]";
	}
}
