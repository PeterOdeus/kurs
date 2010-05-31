package swing.övning22;

import java.util.ArrayList;
import java.util.List;

import telefonbok.Contact;
import telefonbok.PhoneBook;

public class PhoneBookController {
	
	private PhoneBook _phoneBook = null;
	private List<SearchResultHandler> _searchResultTargets = null;
	private DB db = null;
	
	public PhoneBookController(PhoneBook phoneBook){
		db = new DB();
		this._phoneBook = phoneBook;
	}
	
	public void addSearchResultHandler(SearchResultHandler searchResultHandler){
		if(this._searchResultTargets == null){
			this._searchResultTargets = new ArrayList<SearchResultHandler>();
		}
		this._searchResultTargets.add(searchResultHandler);
	}
	
	public void findItemByName(String name){
		List<Contact> contactList = db.select(name);
		List<String> stringList = new ArrayList<String>();
		for(Contact contact : contactList){
			stringList.add(contact.getName() + " : " + contact.getPhoneNumber() + "\n");
		}
		for(SearchResultHandler searchHandler : _searchResultTargets){
			searchHandler.handleSearchResults(stringList);
		}
	}
	
	public void insertContact(Contact contact){
		db.insert(contact);
	}

}
