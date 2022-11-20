

public class Person {

	
	
	String fn;
	String ln;
	String s;
	String date;
	String e;
	
	public Person(String first_name, String last_name, String status, String check_in_date, String email) {
		fn = first_name;
		ln = last_name;
		s = status;
		date = check_in_date;
		e = email;
	}
	
	public Person() {
	}
	


	public void setFirstName(String fn) {
		this.fn = fn;
	}
	
	
	
	public String getFirstName() {
		return fn;
	}
	
	public void setEmail(String e) {
		this.e = e;
	}
	
	public String getEmail() {
		return e;
	}
	
	public void setLastName(String ln) {
		this.ln= ln;
	}
	
	public String getLastName() {
		return ln;
	}
	
	public void setStatus(String s) {
		this.s = s;
	}
	
	public String getStatus() {
		return s;
	}
	
	public void setCheckInDate(String date) {
		this.date = date;
	}
	
	public String getCheckInDate() {
		return date;
	}
	
	public void print() {
		System.out.println("name: " + fn + " " + ln + "\n" +  "status: " + s + "\n"  + "check in date: " + date + "\n" + "email: " + e);
	}
	
	
	
	
}
