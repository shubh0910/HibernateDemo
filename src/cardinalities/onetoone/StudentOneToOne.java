package cardinalities.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class StudentOneToOne {
@Id
private int roll_no;
private String name;
@OneToOne
private LaptopOneToOne lap;

public LaptopOneToOne getLap() {
	return lap;
}
public void setLap(LaptopOneToOne lap) {
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
