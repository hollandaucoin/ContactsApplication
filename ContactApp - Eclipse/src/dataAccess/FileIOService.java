//Holland Aucoin
//January 28, 2019
//CST 135 - 825MWF
//Milestone 2 - FileIOService

package dataAccess;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import businessServices.BusinessService;

public class FileIOService implements DataAccessService {

	

	@Override
	public boolean saveAllContacts(BusinessService contactApp) {
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(new File("contacts.json"), contactApp);
		} 
		catch (JsonGenerationException e) {
			e.printStackTrace();
			return false;
		} 
		catch (JsonMappingException e) {
			e.printStackTrace();
			return false;	
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public BusinessService readAllContacts() {
		
		BusinessService bs = new BusinessService();
		try {
			bs = new ObjectMapper().readerFor(BusinessService.class).readValue(new File("contacts.json"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return bs;
	}
}


	
