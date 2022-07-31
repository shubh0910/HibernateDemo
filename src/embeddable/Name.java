package embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
private String fname;
private String mname;
private String surname;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
@Override
public String toString() {
	return "Name [fname=" + fname + ", mname=" + mname + ", surname=" + surname + "]";
}

}
