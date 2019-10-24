import java.util.Scanner;

import businessServices.BusinessService;
import model.BaseContact;
import model.BusinessContact;
import model.PersonContact;

public class testingOnly {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// CREATE "LIST" FOR ALL DATA IN APPLICATION TO BE STORED IN TO
		BusinessService bs = new BusinessService();

		// INTRO TO APP
		System.out.println("");
		System.out.println("Welcome to the Contacts App");
		System.out.println("");

		// LOAD CONTACTS IN ADDRESS BOOK
	    bs.loadContacts();

		// CREATE BOOLEAN, SET TO TRUE, AND CREATE WHILE LOOP TO REMAIN IN APP
		Boolean inApp = true;

		while (inApp == true) {

			// SHOW CONTACTS APP MENU
			showMenu();

			// PROMPTS USER FOR MENU SELECTION
			System.out.print("Insert menu item number: ");
			int menuInput = in.nextInt();
			//in.nextLine();
			System.out.println("");

			// CHECKS FOR VALID INPUT
			while (menuInput < 0 || menuInput > 12) {
				System.out.print("Sorry, that is not a valid response. Please try again: ");
				menuInput = in.nextInt();
				System.out.println("");
			}

			// CHECK TO SEE IF INPUT IS 1 (ADD NEW)
			if (menuInput == 1) {
				addNew(bs);
			}

			// CHECK TO SEE IF INPUT IS 2 (SHOW ALL)
			else if (menuInput == 2) {
				showAll(bs);
			}

			// CHECK TO SEE IF INPUT IS 3 (SHOW ONE CONTACT)
			else if (menuInput == 3) {
				showOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 4 (CALL CONTACT)
			else if (menuInput == 4) {
				callOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 5 (TEXT CONTACT)
			else if (menuInput == 5) {
				textOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 6 (EMAIL CONTACT)
			else if (menuInput == 6) {
				emailOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 7 (NAVIGATE TO CONTACT)
			else if (menuInput == 7) {
				navigateToOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 8 (OPEN URL OF CONTACT)
			else if (menuInput == 8) {
				openURLofOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 9 (EDIT CONTACT)
			else if (menuInput == 9) {
				editOne(bs);
			}

			// CHECK TO SEE IF INPUT IS 10 (DELETE CONTACT)
			else if (menuInput == 10) {
				deleteOld(bs);
			}

			// CHECK TO SEE IF INPUT IS 11 (SEARCH CONTACTS)
			else if (menuInput == 11) {
				searchFor(bs);
			}
			
			// CHECK TO SEE IF THE INPUT IS 12 (SORT CONTACTS)
			else if (menuInput == 12) {
				sortAll(bs);
			}

			// CHECK TO SEE IF INPUT IS 0 (EXIT)
			else if (menuInput == 0) {
				System.out.println("Any new contacts being saved...");
				bs.saveContacts();
				System.out.println("");
				System.out.println("Exiting app...");
				break;
			}

			// CHECK TO SEE IF USER WANTS TO PERFORM ANOTHER ACTION
			inApp = actionAgain(bs);

		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	// METHOD TO SHOW MENU OPTIONS
	private static void showMenu() {
		System.out.println("Main Menu:");
		System.out.println("   (1) Add New Contact");
		System.out.println("   (2) Show All Contacts");
		System.out.println("   (3) Show One Specific Contact");
		System.out.println("   (4) Call a Contact");
		System.out.println("   (5) Send Text to a Contact");
		System.out.println("   (6) Send Email to a Contact");
		System.out.println("   (7) Navigate to a Contact");
		System.out.println("   (8) Open URL of a Contact");
		System.out.println("   (9) Edit a Contact");
		System.out.println("  (10) Delete a Contact");
		System.out.println("  (11) Search Contacts");
		System.out.println("  (12) Sort Contacts");
		System.out.println("   (0) Exit");
		System.out.println("");
	}

	// METHOD TO ADD A NEW CONTACT
	private static void addNew(BusinessService bs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Creating new contact... Would you like this contact to be a 'personal' or 'business' contact? ");
		String typeContact = in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (!typeContact.equalsIgnoreCase("personal") && !typeContact.equalsIgnoreCase("business")) {
			System.out.print("Sorry, that is not a valid response. Please try again: ");
			typeContact = in.nextLine();
		}

		// PROMPT USER FOR CONTACT ATTRIBUTES
		if (typeContact.equalsIgnoreCase("personal")) {
			System.out.println("");
			System.out.println("Please enter the following information about your new contact.");
			System.out.println("");
			System.out.print("First Name: ");
			String firstName = in.nextLine();
			System.out.print("Last Name: ");
			String lastName = in.nextLine();
			System.out.print("Description: ");
			String description = in.nextLine();
			System.out.print("Phone Number (xxx-xxx-xxxx): ");
			String phoneNumber = in.nextLine();
			System.out.print("Email Address: ");
			String emailAddress = in.nextLine();
			System.out.print("Photo (.jpg): ");
			String photo = in.nextLine();
			System.out.print("Street Address: ");
			String streetAddress = in.nextLine();
			System.out.print("City: ");
			String city = in.nextLine();
			System.out.print("State (XX): ");
			String state = in.nextLine();
			System.out.print("Zip Code: ");
			String zipCode = in.nextLine();
			System.out.print("Country: ");
			String country = in.nextLine();
			System.out.print("Birthday (mm/dd/yyy): ");
			String birthday = in.nextLine();
			System.out.println("");

			// CREATE AND ADD CONTACT
			PersonContact p1 = new PersonContact(firstName, lastName, description, phoneNumber, emailAddress, photo,
					streetAddress, city, state, zipCode, country, birthday);
			System.out.print("Here is your new contact: \n" + p1.toString());
			System.out.println("");
			bs.list.addOne(p1);
		}

		// PROMPT USER FOR CONTACT ATTRIBUTES
		else if (typeContact.equalsIgnoreCase("business")) {
			System.out.println("");
			System.out.println("Please enter the following information about your new contact.");
			System.out.println("");
			System.out.print("Company Name: ");
			String company = in.nextLine();
			System.out.print("Owner First Name: ");
			String firstName = in.nextLine();
			System.out.print("Owner Last Name: ");
			String lastName = in.nextLine();
			System.out.print("Phone Number (xxx-xxx-xxxx): ");
			String phoneNumber = in.nextLine();
			System.out.print("Email Address: ");
			String emailAddress = in.nextLine();
			System.out.print("Photo (.jpg): ");
			String photo = in.nextLine();
			System.out.print("Street Address: ");
			String streetAddress = in.nextLine();
			System.out.print("City: ");
			String city = in.nextLine();
			System.out.print("State (XX): ");
			String state = in.nextLine();
			System.out.print("Zip Code: ");
			String zipCode = in.nextLine();
			System.out.print("Country: ");
			String country = in.nextLine();
			System.out.print("Business Hours (hh:mm AM - hh:mm PM): ");
			String businessHours = in.nextLine();
			System.out.println("Schedule: ");

			// CREATE BOOLEAN OF DAYS OPEN AND PROMPT INPUT
			Boolean[] daysOfWeekOpen = { false, false, false, false, false, false, false };
			String[] days = { "Sunday - ", "Monday - ", "Tuesday - ", "Wednesday - ", "Thursday - ", "Friday - ",
					"Saturday - " };

			for (int i = 0; i <= days.length - 1; i++) {
				System.out.print("Is the business open on " + days[i] + "? (Yes/No): ");
				String scheduleInput = in.nextLine();

				// CHECK FOR VALID INPUT
				while (!scheduleInput.equalsIgnoreCase("yes") && !scheduleInput.equalsIgnoreCase("no")) {
					System.out.print("Sorry, that is not a valid response. Please try again: ");
					scheduleInput = in.nextLine();
				}

				if (scheduleInput.equalsIgnoreCase("yes")) {
					daysOfWeekOpen[i] = true;
				} else if (scheduleInput.equalsIgnoreCase("no")) {
					daysOfWeekOpen[i] = false;
				}
			}

			System.out.print("Website URL: ");
			String websiteURL = in.nextLine();
			System.out.println("");

			// CREATE AND ADD CONTACT
			BusinessContact b1 = new BusinessContact(company, firstName, lastName, phoneNumber, emailAddress, photo,
					streetAddress, city, state, zipCode, country, businessHours, daysOfWeekOpen, websiteURL);
			System.out.print("Here is your new contact: " + b1.toString());
			System.out.println("");
			bs.list.addOne(b1);
		}
	}

	// METHOD TO SHOW ALL CONTACTS
	private static void showAll(BusinessService bs) {
		System.out.println("Address Book:");
		System.out.println("");
		System.out.println(bs.list.toString());
	}

	// METHOD TO SHOW ONE SPECIFIC CONTACT
	private static void showOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to show: ");
		int showInput = in.nextInt();
		in.nextLine();

		// CHECK FOR VALID INPUT
		while (showInput < 0 || showInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			showInput = in.nextInt();
			in.nextLine();
		}
		System.out.println(bs.list.getTheList().get(showInput).toString());
	}

	// METHOD TO CALL ONE SPECIFIC CONTACT
	private static void callOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to call: ");
		int callInput = in.nextInt();
		in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (callInput < 0 || callInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			callInput = in.nextInt();
			in.nextLine();
		}
		bs.list.getTheList().get(callInput).callTo();
	}

	// METHOD TO TEXT ONE SPECIFIC CONTACT
	private static void textOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to text: ");
		int textInput = in.nextInt();
		in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (textInput < 0 || textInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			textInput = in.nextInt();
			in.nextLine();
		}
		bs.list.getTheList().get(textInput).textTo();
	}

	// METHOD TO EMAIL ONE SPECIFIC CONTACT
	private static void emailOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to email: ");
		int emailInput = in.nextInt();
		in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (emailInput < 0 || emailInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			emailInput = in.nextInt();
			in.nextLine();
		}
		bs.list.getTheList().get(emailInput).emailTo();
	}

	// METHOD TO NAVIGATE TO ONE SPECIFIC CONTACT
	private static void navigateToOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to navigate to: ");
		int navigateInput = in.nextInt();
		in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (navigateInput < 0 || navigateInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			navigateInput = in.nextInt();
			in.nextLine();
		}
		bs.list.getTheList().get(navigateInput).navigateTo();
	}

	// METHOD TO OPEN URL OF SPECIFIC BUSINESS CONTACT
	private static void openURLofOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to open the URL of: ");
		int openURLInput = in.nextInt();
		in.nextLine();
		System.out.println("");

		// CHECK FOR VALID INPUT
		while (openURLInput < 0 || openURLInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			openURLInput = in.nextInt();
			in.nextLine();
		}

		// CHECK CONTACT CLASS
		while (bs.list.getTheList().get(openURLInput).getClass() != BusinessContact.class) {
			System.out.print("Sorry, the contact you chose doesn't contain a URL to open. Please select a business contact position: ");
			openURLInput = in.nextInt();
			in.nextLine();
		}
		System.out.println("");
		bs.list.getTheList().get(openURLInput).openURL();
		System.out.println("");
	}

	// METHOD TO EDIT ONE SPECIFIC CONTACT
	private static void editOne(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to edit: ");
		int editInput = in.nextInt();
		in.nextLine();

		// CHECK FOR VALID INPUT
		while (editInput < 0 || editInput >= bs.list.getTheList().size()) {
			System.out.println("");
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			editInput = in.nextInt();
			in.nextLine();
		}

		
		
		// CHECK TO SEE IF ITS A PERSONAL CONTACT
		if (bs.list.getTheList().get(editInput).getClass() == PersonContact.class) {
			
			PersonContact p = (PersonContact) bs.list.getTheList().get(editInput);
			System.out.println("");
			System.out.println("Current details of that contact -");
			System.out.println("   (1) First Name: " + p.getFirstName());
			System.out.println("   (2) Last Name: " + p.getLastName());
			System.out.println("   (3) Description: " + p.getDescription());
			System.out.println("   (4) Phone Number: " + p.getPhoneNumber());
			System.out.println("   (5) Email Address: " + p.getEmailAddress());
			System.out.println("   (6) Photo: " + p.getPhoto());
			System.out.println("   (7) Street Address: " + p.getStreetAddress());
			System.out.println("   (8) City: " + p.getCity());
			System.out.println("   (9) State: " + p.getState());
			System.out.println("  (10) Zip Code: " + p.getZipCode());
			System.out.println("  (11) Country: " + p.getCountry());
			System.out.println("  (12) Birthday: " + p.getBirthday());
			System.out.println("");

			// LOOP TO STAY IN EDIT MODE
			Boolean inEdit = true;

			while (inEdit == true) {

				System.out.print("Insert detail item number to change: ");
				int editDetail = in.nextInt();
				in.nextLine();
				System.out.println("");

				// CHECK FOR VALID INPUT
				while (editDetail <= 0 || editDetail > 12) {
					System.out.print("Sorry, that is not a valid response. Please try again: ");
					editDetail = in.nextInt();
					System.out.println("");
				}

				if (editDetail == 1) {
					System.out.print("Please enter the new First Name: ");
					String newFirstName = in.nextLine();
					p.setFirstName(newFirstName);
				} 
				else if (editDetail == 2) {
					System.out.print("Please enter the new Last Name: ");
					String newLastName = in.nextLine();
					p.setLastName(newLastName);
				} 
				else if (editDetail == 3) {
					System.out.print("Please enter the new Description: ");
					String newDescription = in.nextLine();
					p.setDescription(newDescription);
				} 
				else if (editDetail == 4) {
					System.out.print("Please enter the new Phone Number (xxx-xxx-xxxx): ");
					String newPhoneNumber = in.nextLine();
					p.setPhoneNumber(newPhoneNumber);
				} 
				else if (editDetail == 5) {
					System.out.print("Please enter the new Email Address: ");
					String newEmailAddress = in.nextLine();
					p.setEmailAddress(newEmailAddress);
				} 
				else if (editDetail == 6) {
					System.out.print("Please enter the new Photo (.jpg): ");
					String newPhoto = in.nextLine();
					p.setPhoto(newPhoto);
				} 
				else if (editDetail == 7) {
					System.out.print("Please enter the new Street Address: ");
					String newStreetAddress = in.nextLine();
					p.setStreetAddress(newStreetAddress);
				} 
				else if (editDetail == 8) {
					System.out.print("Please enter the new City: ");
					String newCity = in.nextLine();
					p.setCity(newCity);
				} 
				else if (editDetail == 9) {
					System.out.print("Please enter the new State (XX): ");
					String newState = in.nextLine();
					p.setState(newState);
				} 
				else if (editDetail == 10) {
					System.out.print("Please enter the new Zip Code: ");
					String newZipCode = in.nextLine();
					p.setZipCode(newZipCode);
				} 
				else if (editDetail == 11) {
					System.out.print("Please enter the new Country: ");
					String newCountry = in.nextLine();
					p.setCountry(newCountry);
				} 
				else if (editDetail == 12) {
					System.out.print("Please enter the new Birthday (mm/dd/yyyy): ");
					String newBirthday = in.nextLine();
					p.setBirthday(newBirthday);
				}

				System.out.println("");
				System.out.print("Do you want to edit anything else? (Yes/No): ");
				String stayEdit = in.nextLine();

				// CHECK FOR VALID INPUT
				while (!stayEdit.equalsIgnoreCase("yes") && !stayEdit.equalsIgnoreCase("no")) {
					System.out.print("Sorry, that is not a valid answer. Please try again: ");
					stayEdit = in.nextLine();
					System.out.println("");
				}

				// IF STATEMENT TO STAY OR LEAVE EDIT WHILE LOOP
				if (stayEdit.equalsIgnoreCase("yes")) {
					inEdit = true;
					System.out.println("");
				} 
				else if (stayEdit.equalsIgnoreCase("no")) {
					inEdit = false;
					
					// OUTPUT EDITTED CONTACT
					System.out.println("");
					System.out.println("Editted contact: " + bs.list.getTheList().get(editInput));
					System.out.println("");
				}
				bs.list.getTheList().remove(editInput);
				bs.list.getTheList().add(p);
			}
		}

		// CHECK TO SEE IF ITS A BUSINESS CONTACT
		else if (bs.list.getTheList().get(editInput).getClass() == BusinessContact.class) {
			BusinessContact b = (BusinessContact) bs.list.getTheList().get(editInput);
			System.out.println("");
			System.out.println("Current details of that contact -");
			System.out.println("   (1) Company: " + b.getCompany());
			System.out.println("   (2) First Name: " + b.getFirstName());
			System.out.println("   (3) Last Name: " + b.getLastName());
			System.out.println("   (4) Phone Number: " + b.getPhoneNumber());
			System.out.println("   (5) Email Address: " + b.getEmailAddress());
			System.out.println("   (6) Photo: " + b.getPhoto());
			System.out.println("   (7) Street Address: " + b.getStreetAddress());
			System.out.println("   (8) City: " + b.getCity());
			System.out.println("   (9) State: " + b.getState());
			System.out.println("  (10) Zip Code: " + b.getZipCode());
			System.out.println("  (11) Country: " + b.getCountry());
			System.out.println("  (12) Business Hours: " + b.getBusinessHours());
			System.out.println("  (13) Schedule: " + b.getDaysOfWeekOpen().toString());
			System.out.println("  (14) Website URL: " + b.getWebsiteURL());
			System.out.println("");

			// LOOP TO STAY IN EDIT MODE
			Boolean inEdit = true;

			while (inEdit == true) {

				System.out.print("Insert detail item number to change: ");
				int editDetail = in.nextInt();
				in.nextLine();
				System.out.println("");

				// CHECK FOR VALID INPUT
				while (editDetail <= 0 || editDetail > 14) {
					System.out.print("Sorry, that is not a valid response. Please try again: ");
					editDetail = in.nextInt();
					System.out.println("");
				}

				if (editDetail == 1) {
					System.out.print("Please enter the new Company: ");
					String newCompany = in.nextLine();
					b.setCompany(newCompany);
				} 
				else if (editDetail == 2) {
					System.out.print("Please enter the new First Name: ");
					String newFirstName = in.nextLine();
					b.setFirstName(newFirstName);
				} 
				else if (editDetail == 3) {
					System.out.print("Please enter the new Last Name: ");
					String newLastName = in.nextLine();
					b.setLastName(newLastName);
				} 
				else if (editDetail == 4) {
					System.out.print("Please enter the new Phone Number (xxx-xxx-xxxx): ");
					String newPhoneNumber = in.nextLine();
					b.setPhoneNumber(newPhoneNumber);
				} 
				else if (editDetail == 5) {
					System.out.print("Please enter the new Email Address: ");
					String newEmailAddress = in.nextLine();
					b.setEmailAddress(newEmailAddress);
				} 
				else if (editDetail == 6) {
					System.out.print("Please enter the new Photo (.jpg): ");
					String newPhoto = in.nextLine();
					b.setPhoto(newPhoto);
				} 
				else if (editDetail == 7) {
					System.out.print("Please enter the new Street Address: ");
					String newStreetAddress = in.nextLine();
					b.setStreetAddress(newStreetAddress);
				} 
				else if (editDetail == 8) {
					System.out.print("Please enter the new City: ");
					String newCity = in.nextLine();
					b.setCity(newCity);
				} 
				else if (editDetail == 9) {
					System.out.print("Please enter the new State (XX): ");
					String newState = in.nextLine();
					b.setState(newState);
				} 
				else if (editDetail == 10) {
					System.out.print("Please enter the new Zip Code: ");
					String newZipCode = in.nextLine();
					b.setZipCode(newZipCode);
				} 
				else if (editDetail == 11) {
					System.out.print("Please enter the new Country: ");
					String newCountry = in.nextLine();
					b.setCountry(newCountry);
				} 
				else if (editDetail == 12) {
					System.out.print("Please enter the new Business Hours (hh:mm AM - hh:mm PM): ");
					String newBusinessHours = in.nextLine();
					b.setBusinessHours(newBusinessHours);
				} 
				else if (editDetail == 13) {
					System.out.print("Please enter the new Schedule: ");
					System.out.println("");
					;

					// CREATE BOOLEAN OF DAYS OPEN AND PROMPT INPUT
					Boolean[] daysOfWeekOpen = { false, false, false, false, false, false, false };
					String[] days = { "Sunday - ", "Monday - ", "Tuesday - ", "Wednesday - ", "Thursday - ",
							"Friday - ", "Saturday - " };

					for (int i = 0; i <= days.length - 1; i++) {
						System.out.print("Is the business open on " + days[i] + "? (Yes/No): ");
						String newScheduleInput = in.nextLine();

						// CHECK FOR VALID INPUT
						while (!newScheduleInput.equalsIgnoreCase("yes") && !newScheduleInput.equalsIgnoreCase("no")) {
							System.out.print("Sorry, that is not a valid response. Please try again: ");
							newScheduleInput = in.nextLine();
						}

						if (newScheduleInput.equalsIgnoreCase("yes")) {
							daysOfWeekOpen[i] = true;
						} else if (newScheduleInput.equalsIgnoreCase("no")) {
							daysOfWeekOpen[i] = false;
						}
					}
					b.setDaysOfWeekOpen(daysOfWeekOpen);
				} 
				else if (editDetail == 14) {
					System.out.print("Please enter the new Website URL: ");
					String newWebsiteURL = in.nextLine();
					b.setWebsiteURL(newWebsiteURL);
				}

				System.out.println("");
				System.out.print("Do you want to edit anything else? (Yes/No): ");
				String stayEdit = in.nextLine();

				// CHECK FOR VALID INPUT
				while (!stayEdit.equalsIgnoreCase("yes") && !stayEdit.equalsIgnoreCase("no")) {
					System.out.print("Sorry, that is not a valid answer. Please try again: ");
					stayEdit = in.nextLine();
					System.out.println("");
				}

				// IF STATEMENT TO STAY OR LEAVE EDIT WHILE LOOP
				if (stayEdit.equalsIgnoreCase("yes")) {
					inEdit = true;
					System.out.println("");
				} 
				else if (stayEdit.equalsIgnoreCase("no")) {
					inEdit = false;
					
					// OUTPUT EDITTED CONTACT
					System.out.println("");
					System.out.println("Editted contact: " + bs.list.getTheList().get(editInput));
					System.out.println("");
				}
				
				bs.list.getTheList().remove(editInput);
				bs.list.getTheList().add(b);
			}
		}
	}

	// METHOD TO DELETE ONE SPECIFIC CONTACT
	private static void deleteOld(BusinessService bs) {
		System.out.println("Contacts: ");
		for (int i = 0; i < bs.list.size(); i++) {
			System.out.println("   (" + i + ") " + bs.list.getTheList().get(i).getFirstName() + " " + bs.list.getTheList().get(i).getLastName());
		}
		
		System.out.println("");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the position of the contact you would like to delete: ");
		int deleteInput = in.nextInt();
		in.nextLine();

		// CHECK FOR VALID INPUT
		while (deleteInput < 0 || deleteInput >= bs.list.getTheList().size()) {
			System.out.print("Sorry, there is no contact at that position. Please try again: ");
			deleteInput = in.nextInt();
			in.nextLine();
		}
		BaseContact deleteContact = bs.list.getTheList().get(deleteInput);
		bs.list.deleteOne(deleteContact);
		
		// SHOW UPDATED CONTACTS LIST
		System.out.println("Updated contacts list: \n" + bs.list.toString());
	}

	// METHOD TO SEARCH CONTACTS
	private static void searchFor(BusinessService bs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Search for: ");
		String searchInput = in.nextLine();
		System.out.println("");
		
		if (bs.list.searchForOutput(searchInput) ==  null) {
			System.out.print("Sorry, there are no contacts that match your search.");
			System.out.println("");
		}
		else {
		System.out.print(bs.list.searchForOutput(searchInput).toString());
		}
	}
	
	// METHOD TO SORT CONTACTS
	private static void sortAll(BusinessService bs) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter how you want your contacts to be ordered (First/Last Name): ");
		String sortOrder = in.nextLine();
		System.out.println("");
		
		while (!sortOrder.equalsIgnoreCase("first name") && !sortOrder.equalsIgnoreCase("first") && !sortOrder.equalsIgnoreCase("last name") && !sortOrder.equalsIgnoreCase("last")) {
			System.out.print("Sorry, that is not a valid answer. Please try again: ");
			sortOrder = in.nextLine();
			System.out.println("");
		}
		
		if (sortOrder.equalsIgnoreCase("first name") || sortOrder.equalsIgnoreCase("first")) {
			bs.list.sortByFirstName();
			System.out.println("Ordered contacts (First name): ");
			System.out.println(bs.list.toString());
		}
		else if (sortOrder.equalsIgnoreCase("last name") || sortOrder.equalsIgnoreCase("last")){
			bs.list.sortByLastName();
			System.out.println("Ordered contacts (Last name): ");
			System.out.println(bs.list.toString());
		}
	}

	// METHOD TO PERFORM ANOTHER ACTION OR EXIT APP
	private static Boolean actionAgain(BusinessService bs) {
		Scanner in = new Scanner(System.in);
		Boolean inApp = true;

		System.out.println("");
		System.out.print("Do you want to perform another action? (Yes/No): ");
		String userAnswer = in.nextLine();
		System.out.println("");

		while (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no")) {
			System.out.print("Sorry, that is not a valid answer. Please try again: ");
			userAnswer = in.nextLine();
			System.out.println("");
		}

		if (userAnswer.equalsIgnoreCase("yes")) {
			return true;
		} else if (userAnswer.equalsIgnoreCase("No")) {
			System.out.println("Any new contacts being saved...");
			bs.saveContacts();
			System.out.println("");
			System.out.println("Exiting app...");
			return false;
		}
		return false;
	}
}
