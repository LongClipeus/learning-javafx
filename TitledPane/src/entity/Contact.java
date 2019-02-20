package entity;

public class Contact {

	private Account account;
	private String firstName;
	private String lastName;
	private String gendel;
	private String contact;

	public Contact() {
		super();
	}

	public Contact(Account account, String firstName, String lastName, String gendel, String contact) {
		super();
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gendel = gendel;
		this.contact = contact;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public String getGendel() {
		return gendel;
	}

	public void setGendel(String gendel) {
		this.gendel = gendel;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
