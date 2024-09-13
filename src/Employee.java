public class Employee {
	// Fields
	private String firstName;
	private String lastName;
	private String ssn;
	private long phone;
	private String email;

	// Constructor
	public Employee(String firstName, String lastName, String ssn, long phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.phone = phone;
		this.email = email;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	// toString method to display product information
	@Override
	public String toString() {
		return "Employee{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", ssn='" + ssn + '\'' +
				", phone=" + phone +
				", email='" + email + '\'' +
				'}';
	}
}
