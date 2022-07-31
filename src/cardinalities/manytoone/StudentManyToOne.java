package cardinalities.manytoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentManyToOne {
	@Id
	private int roll_no;
	private String name;
	@OneToMany(mappedBy="student")
	private List<LaptopManyToOne> lap=new ArrayList<LaptopManyToOne>();

	public List<LaptopManyToOne> getLap() {
		return lap;
	}
	public void setLap(List<LaptopManyToOne> lap) {
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
		return "StudentOneToOne [roll_no=" + roll_no + ", name=" + name + "]";
	}

}
