package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


public class AddressBook {

	private List<BaseContact> theList;
	
	// EMPTY LIST OF BASE CONTACTS
	public AddressBook() {
		this.theList = new ArrayList<BaseContact>();
	}
	
	// ADD SPECIFIC CONTACT (T generic allows pull from either business or person class) - GENERIC
	public <T extends BaseContact> void addOne(T contact) {
		this.theList.add(contact);
	}
	
	// REMOVE SPECIFIC CONTACT (T generic allows pull from either business or person class) - GENERIC
	public <T extends BaseContact> void deleteOne(T contact) {
		this.theList.remove(contact);
	}
	
	// SORT BY
	public void sortByFirstName() {
		theList.sort(Comparator.comparing(BaseContact::getFirstName));
	}
	public void sortByLastName() {
		theList.sort(Comparator.comparing(BaseContact::getLastName));
	}
	   
	 
		
	// OUTPUT SEARCH MATCH
	public AddressBook searchForOutput(String string) {

		AddressBook searchList = new AddressBook();

		for (int i = 0; i < theList.size(); i++) {
			if (theList.get(i).getFirstName().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getLastName().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getPhoneNumber().contains(string)) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getEmailAddress().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getPhoto().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getStreetAddress().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getCity().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getState().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getZipCode().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			} 
			else if (theList.get(i).getCountry().toLowerCase().contains(string.toLowerCase())) {
				searchList.addOne(theList.get(i));
			}
		}
		
		if (searchList.size() == 0) {
			return null;
		}
		else {
			return searchList;
		}
	}

	public int size() {
		return theList.size();
	}
	
	public List<BaseContact> getTheList() {
		return theList;
	}

	public void setTheList(List<BaseContact> theList) {
		this.theList = theList;
	}


	@Override
	public String toString() {
		
		String book = "";

		for (int i = 0; i < theList.size(); i++) {
			book += "  * Position " + i + " * " + theList.get(i).toString() + "\n";
		}
		return book;
	}
	
	
	

}
