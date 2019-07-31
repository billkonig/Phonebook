package thursday;

import java.util.Arrays;
import java.util.Scanner;
import thursday.Address;
import thursday.Person;
import thursday.PhoneBook;

public class Application {

	static Scanner sc = new Scanner(System.in);
	static PhoneBook phonebook = new PhoneBook();
	
	public static void main(String[] args) {
	
		menu();
	}
	public static void menu() {
		
		System.out.println("Select an option (1-11)");
		System.out.println("1. Add contact");
		System.out.println("2. Search for contact by first name");
		System.out.println("3. Search for contact by last name");
		System.out.println("4. Search for contact by full name");
		System.out.println("5. Search for contact by city");
		System.out.println("6. Search for contact by state");
		System.out.println("7. Search for contact by telephone number");
		System.out.println("8. Update contact");
		System.out.println("9: Delete contact");
		System.out.println("10: Print all contacts");
		System.out.println("11. Exit program");
		String option = sc.nextLine();
			
		switch(option) 
		{	
		case "1":
			System.out.print("Enter information of contact to add in the following format - FirstName LastName, Street Address, City, State, " + 
			"Zipcode, Telephone Number:\n");
			String input = sc.nextLine();
			phonebook.addContact(input);
			break;
		case "2":
			phonebook.searchFirstName();
			break;
		case "3":
			phonebook.searchLastName();
			break;
		case "4":
			phonebook.searchFullName();
			break;	
		case "5":
			phonebook.searchCity();
			break;
		case "6":
			phonebook.searchState();
			break;
		case "7":
			phonebook.searchTelephoneNo();
			break;
		case "8":
			phonebook.updateContact();
			break;
		case "9":
			phonebook.deleteContact();
			break;
		case "10":
			phonebook.printContacts();
			break;
		case "11":
			System.exit(0);
		default:
			System.out.print("Not valid.\n\n");
		}
		menu();
	}
}	
		
		
		
		
		
		
		
		
		



