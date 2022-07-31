package cardinalities.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class StudentManyToMany {
	@Id
	private int roll_no;
	private String name;
	@javax.persistence.ManyToMany(mappedBy="student")
	private List<LaptopManyToMany> lap=new ArrayList<LaptopManyToMany>();

	public List<LaptopManyToMany> getLap() {
		return lap;
	}
	public void setLap(List<LaptopManyToMany> lap) {
		this.lap = lap;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentOneToOne [roll_no=" + roll_no + ", name=" + name +lap +"]";
	}
}
