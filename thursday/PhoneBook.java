package thursday;

import java.util.Arrays;
import java.util.Scanner;
import thursday.Address;
import thursday.Person;

public class PhoneBook {
	
	static Scanner sc = new Scanner(System.in);
	
	//Lines 13-15 are all class variables.
	static Person person = new Person();
	static Address address = new Address();
	static Person[] people = new Person[0];
	
	public PhoneBook() {}
	
	private Person[] addToPeople(Person[] person, Person people) {
		
		Person[] tempArray = new Person[person.length + 1];
		
		for (int i = 0; i < person.length; i++) {
			tempArray[i] = person[i];
		}
			person = tempArray;
			person [person.length - 1] = people;
		
			return person;
	}
	public void printContacts() {
		
		//Sorting the "people" array in ascending order by last name.
		Arrays.sort(people, (a, b) -> a.getLastName().compareTo(b.getLastName()));

		for(int i = 0; i < people.length; i++){
			System.out.println(people[i].getFirstName() + " " + people[i].getLastName() + "\n" + people[i].getAddress() + "\n" + 
			people[i].getTelephoneNo().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") + "\n");
		}
	}
	public void addContact(String input) {	
		
		Person newPerson = new Person(input);
			
		people = addToPeople(people, newPerson);
			
		System.out.println("Contact added:\n" + newPerson);
	}
	void searchFirstName() {
		
		System.out.print("Enter first name of contact to find: ");
		String firstNameToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getFirstName().equalsIgnoreCase(firstNameToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void searchLastName() {
				
		System.out.print("Enter last name of contact to find: ");
		String lastNameToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getLastName().equalsIgnoreCase(lastNameToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void searchFullName() {
		
		System.out.print("Enter first name of contact to find: ");
		String firstNameToFind = sc.nextLine();
		System.out.print("Enter last name of contact to find: ");
		String lastNameToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getFirstName().equalsIgnoreCase(firstNameToFind) && people[i].getLastName().equalsIgnoreCase(lastNameToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void searchCity() {
		
		System.out.print("Enter city of contact to find: ");
		String cityToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getAddress().getCity().equalsIgnoreCase(cityToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void searchState() {
		
		System.out.print("Enter state of contact to find: ");
		String stateToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getAddress().getState().equalsIgnoreCase(stateToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void searchTelephoneNo() {
		
		System.out.print("Enter telephone number of contact to find: ");
		String telephoneNoToFind = sc.nextLine();
		
		for(int i = 0; i < people.length; i++) {
			if (people[i].getTelephoneNo().equals(telephoneNoToFind)) {
				System.out.println(people[i]);
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
	void updateContact() {
		
		System.out.print("Enter telephone number of contact to update: ");
		String contactToUpdate = sc.nextLine();

		for(int i = 0; i < people.length; i++) {
			if (people[i].getTelephoneNo().equals(contactToUpdate)) 
				{
				System.out.print("Enter new first name: ");
				String firstName = sc.nextLine();
				person.setFirstName(firstName);
				System.out.print("Enter new last name: ");
				String lastName = sc.nextLine();
				person.setLastName(lastName);
				System.out.print("Enter new street address: ");
				String street = sc.nextLine();
				person.setAddress(address);
				address.setStreet(street);
				System.out.print("Enter new city: ");
				String city = sc.nextLine();
				address.setCity(city);
				System.out.print("Enter new state: ");
				String state = sc.nextLine();
				address.setState(state);
				System.out.print("Enter new zipcode: ");
				String zipcode = sc.nextLine();
				address.setZipcode(zipcode);
				System.out.print("Enter new telephone number: ");
				String telephoneNo = sc.nextLine();
				person.setTelephoneNo(telephoneNo);
				
				System.out.println("You updated contact:\n" + person);
				}
			else	
				{
				System.out.println("Contact not found\n");
				}
		}
	}
	void deleteContact() {
		
		System.out.print("Enter telephone number of contact to delete: ");
		String contactToDelete = sc.nextLine();
		Person[] tempArray = new Person[people.length - 1];
		int j = 0;
		
		//Telling the program to loop through "people" array (line 185) and if the telephone number from the input "contactToDelete" matches the
		//telephone number of the element at index point "i", it will do nothing (lines 187-189).  But if they don't match, it will be added to the 
		//empty array "tempArray" at index point "j" (line 191) and then "j" will go up by one (line 192) so that the next element at index point "i"
		//to be added to "tempArray" will have the next space (at "j"'s new spot (at + 1)) in the array available to it to fill.
		for(int i = 0; i < people.length; i++) {
			if (people[i].getTelephoneNo().equals(contactToDelete)) {
				if (people[i].getTelephoneNo().equals(contactToDelete)) {
					//Doing nothing.
				}
				else {
					tempArray[j] = people[i];
					j++;
				}
				//Filling the "people" array with the elements from "tempArray", which now has all the values of the elements that did not match the
				//value of "contactToDelete" (effectively removing "contactToDelete" from the "people" array).
				people = tempArray;
				System.out.println("Contact deleted.\n");
			}
			else {
				System.out.println("Contact not found.\n");
			}
		}
	}
}
	

