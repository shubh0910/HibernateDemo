package objectStates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ObjectTable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int no;
	private String name;
	private String city;

	public ObjectTable() {}
	
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
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "ObjectTable [no=" + no + ", name=" + name + ", city=" + city + "]";
	}

}