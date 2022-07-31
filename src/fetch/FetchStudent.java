package fetch;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FetchStudent {
@Id
private int sid;
private String name;
//@OneToMany(mappedBy="student")
@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
private Collection<FetchLaptop> lap=new ArrayList<FetchLaptop>();
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Collection<FetchLaptop> getLap() {
	return lap;
}
public void setLap(Collection<FetchLaptop> lap) {
	this.lap = lap;
}

@Override
public String toString() {
	return "[sid=" + sid + ", name=" + name+ "]";
} 

}
