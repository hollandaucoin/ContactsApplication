package dataAccess;

import businessServices.BusinessService;
import model.AddressBook;

public interface DataAccessService {

	public BusinessService readAllContacts();
	boolean saveAllContacts(BusinessService contactApp);
	
}
