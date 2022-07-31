package cardinalities.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class StudentOneToMany {
@Id
private int roll_no;
private String name;
@OneToMany
private List<LaptopOneToMany> lap=new ArrayList<LaptopOneToMany>();

public List<LaptopOneToMany> getLap() {
	return lap;
}
public void setLap(List<LaptopOneToMany> lap) {
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
	return "StudentOneToMany [roll_no=" + roll_no + ", name=" + name + ", lap=" + lap + "]";
}



}
