package model;

public class Contact {
	private String _name;
	private PhoneNumber _phoneNumber;	
	
	public Contact(String name, PhoneNumber phoneNumber){
		this._name = name;
		this._phoneNumber = phoneNumber;
	}

	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		this._name = name;
	}


	public PhoneNumber getPhoneNumber() {
		return _phoneNumber;
	}	

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this._phoneNumber = phoneNumber;
	}
	
}
