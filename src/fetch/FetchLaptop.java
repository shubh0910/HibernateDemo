package fetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FetchLaptop {
@Id
private int lid;
private String brand;
private int price;
@ManyToOne
private FetchStudent student;

public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public FetchStudent getStudent() {
	return student;
}
public void setStudent(FetchStudent student) {
	this.student = student;
}
@Override
public String toString() {
	return "[lid=" + lid + ", brand=" + brand + ", price=" + price + ", student=" + student + "]";
}


}
