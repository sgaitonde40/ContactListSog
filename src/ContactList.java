import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    ArrayList<Person> contacts;

    // TODO: Write a Constructor

    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        int answer = 0;
        String first = "";
        String last = "";
        String pn = "";
        Scanner input = new Scanner(System.in);
        while(answer != 1 && answer != 2) {
            System.out.println("Select the type of contact to add:");
            System.out.println("1. Student");
            System.out.println("2. Athlete");
            answer = input.nextInt();
        }
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        first = input.nextLine();
        first = input.nextLine();
        System.out.println("Last Name: ");
        last = input.nextLine();
        System.out.println("Phone Number: ");
        pn = input.nextLine();
        if (answer == 1) {
            int grade = 0;
            System.out.println("Grade: ");
            grade = input.nextInt();
            Student contact = new Student(first, last, pn, grade);
            contacts.add(contact);
        }
        else {
            String sport = "";
            System.out.println("Sport: ");
            sport = input.nextLine();
            Athlete contact = new Athlete(first, last, pn, sport);
            contacts.add(contact);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        int comparator;
        if(sortBy == 0) {
            for(int i = 0; i < contacts.size(); i++) {
                comparator = 0;
                if(contacts.size() == 1) {
                    System.out.println(contacts.get(i));
                }
                if (i < contacts.size() - 1) {
                   comparator = contacts.get(i).getFirstName().compareTo(contacts.get(i+1).getFirstName());
                }
                if (comparator > 0) {
                    Person swapper = contacts.remove(i);
                    contacts.add(i+1, swapper);
                }
            }
            for(int i = 0; i < contacts.size(); i++) {
                System.out.println(contacts.get(i));
            }
        }
        else if(sortBy == 1) {
            for(int i = 0; i < contacts.size(); i++) {
                comparator = 0;
                if(contacts.size() == 1) {
                    System.out.println(contacts.get(i));
                }
                if (i < contacts.size() - 1) {
                    comparator = contacts.get(i).getLastName().compareTo(contacts.get(i+1).getLastName());
                }
                if (comparator > 0) {
                    Person swapper = contacts.remove(i);
                    contacts.add(i+1, swapper);
                }
            }
            for(int i = 0; i < contacts.size(); i++) {
                System.out.println(contacts.get(i));
            }

        }
        else if(sortBy == 2) {
            for(int i = 0; i < contacts.size(); i++) {
                comparator = 0;
                if(contacts.size() == 1) {
                    System.out.println(contacts.get(i));
                }
                if (i < contacts.size() - 1) {
                    comparator = contacts.get(i).getPhoneNumber().compareTo(contacts.get(i+1).getPhoneNumber());
                }
                if (comparator > 0) {
                    Person swapper = contacts.remove(i);
                    contacts.add(i+1, swapper);
                }
            }
            for(int i = 0; i < contacts.size(); i++) {
                System.out.println(contacts.get(i));
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String first) {
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getFirstName().equals(first)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String last) {
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getLastName().equals(last)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String PN) {
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getLastName().equals(PN)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        // TODO: Complete the run method
        int ans = -1;
        Scanner s = new Scanner(System.in);
        while(ans != 0) {
            System.out.println("Welcome to your Contacts List");
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            ans = s.nextInt();
            if(ans == 1) {
                addContact();
            }
            else if(ans == 2) {
                sort(0);
            }
            else if(ans == 3) {
                sort(1);
            }
            else if(ans == 4) {
                sort(2);
            }
            else if(ans == 5) {
                listStudents();
            }
            else if(ans == 6) {
                ans = 0;
                System.out.println("What name would you like to search by? ");
                String first = s.nextLine();
                System.out.println(searchByFirstName(first));
                ans = 6;
            }
            else if(ans == 7) {
                ans = 0;
                System.out.println("What name would you like to search by? ");
                String last = s.nextLine();
                System.out.println(searchByLastName(last));
                ans = 7;
            }
            else if(ans == 8) {
                ans = 0;
                System.out.println("What name would you like to search by? ");
                String PN = s.nextLine();
                System.out.println(searchByPhoneNumber(PN));
                ans = 8;
            }
            else if(ans == 9) {
                printContacts();
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
