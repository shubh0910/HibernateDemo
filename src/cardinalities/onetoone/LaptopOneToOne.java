package cardinalities.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class LaptopOneToOne {
	@Id
	private int lid;
	private String lname;
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
	@Override
	public String toString() {
		return "Student [lid=" + lid + ", lname=" + lname + "]";
	}
}
