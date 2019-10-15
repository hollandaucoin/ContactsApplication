//Holland Aucoin
//January 28, 2019
//CST 135 - 825MWF
//Milestone 2 - BusinessService

package businessServices;

import dataAccess.DataAccessService;
import dataAccess.FileIOService;
import model.AddressBook;


public class BusinessService {

	// HOLDS GLOBAL VARIABLES AND METHODS TO PERSIST DATA ("list" is the main data storage for entire application)
	
	public AddressBook list;
	
	public BusinessService (AddressBook list) {
		super();
		this.setList(list);
	}
	
	public BusinessService () {
		super();
		this.setList(new AddressBook());
	}

	// WRITES ALL DATA TO FILE/DATABASE
	public void saveContacts() {
		DataAccessService das = new FileIOService();
		das.saveAllContacts(this);
	}
	
	// READ DATA FROM FILE/DATABASE
	public void loadContacts() {
		DataAccessService das = new FileIOService();
		this.list = das.readAllContacts().list;
	}
	
	
	public AddressBook getList() {
		return list;
	}

	public void setList(AddressBook list) {
		this.list = list;
	}
	
	
	
}
