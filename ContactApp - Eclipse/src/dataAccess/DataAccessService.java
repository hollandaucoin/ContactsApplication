//Holland Aucoin
//February 25, 2019
//CST 135 - 825MWF
//Milestone 4 - DataAccessService

package dataAccess;

import businessServices.BusinessService;
import model.AddressBook;

public interface DataAccessService {

	public BusinessService readAllContacts();
	boolean saveAllContacts(BusinessService contactApp);
	
}
