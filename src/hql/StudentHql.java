package hql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentHql {
@Id
private int roll_no;
private String name;
private String city;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "StudentHql [roll_no=" + roll_no + ", name=" + name + ", city=" + city + "]";
}


}
