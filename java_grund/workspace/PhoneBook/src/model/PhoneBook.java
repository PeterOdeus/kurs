package model;

public class PhoneBook {
	
	private Contact [] contacts = new Contact[5];
	private byte numberOfContacts;
	public PhoneBook(){	
		contacts[0] = new Contact("Peter", new PhoneNumber("555-123"));
		contacts[1] = new Contact("Johan", new PhoneNumber("555-223"));
		contacts[2] = new Contact("Kaj", new PhoneNumber("555-323"));
		contacts[3] = new Contact("Magnus", new PhoneNumber("555-423"));
		contacts[4] = new Contact("Daniel", new PhoneNumber("555-523"));
	}
	
	void addContact(Contact c){
		if(numberOfContacts > 4){
			return;
		}
		contacts[numberOfContacts] = c;
		numberOfContacts++;
	}
	
	public Contact [] getContactsByName(String aName){
		return contacts;
	}

}
