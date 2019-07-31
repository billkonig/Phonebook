package thursday;

public class Person {

	private String firstName;
	private String lastName;
	private Address address;
	private String telephoneNo;
	
	public Person() {}
	public Person(String input) {

	String[] parsedEntry = input.split(", ");
	String[] parsedName = parsedEntry[0].split(" ");

	this.firstName = parsedName[0];
	this.lastName = parsedName[parsedName.length - 1];
	this.address = new Address(parsedEntry[1], parsedEntry[2], parsedEntry[3], parsedEntry[4]);
	this.telephoneNo = parsedEntry[5];
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String toString() {
		//At the end of this "return" command line, we are formatting the "telephoneNo" value so that no matter how it is entered (e.g. 3142865443),
		//it will be returned in the format: (###) ###-####.
		return firstName + " " + lastName + "\n" + address + "\n" + telephoneNo.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") + "\n";
	}
}
