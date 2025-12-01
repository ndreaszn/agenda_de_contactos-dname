import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] contactName = new String[100];
        String[] contactPhone = new String[100];
        int contactAmount = 0;

        boolean loop = true;

        while (loop) {

            System.out.println("-------------------------------------------------");
            System.out.println("1. Add contact");
            System.out.println("2. Show contacts");
            System.out.println("3. Modify contact");
            System.out.println("4. Exit");

            System.out.print("Choose from 1-4: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Option " + choice + " chosen. Please wait a moment...");
                    System.out.println("Welcome to the contact addition center!");
                    System.out.println();
                    System.out.println("Would you like to add a contact? (y/n)");
                    scanner.nextLine();
                    String addContact = scanner.nextLine();
                        switch (addContact) {
                            case "y":
                                if (contactAmount < 100) {
                                    System.out.println("Please enter the contact name:");
                                    contactName[contactAmount] = scanner.nextLine();
                                    System.out.println("Please enter the contact phone number:");
                                    contactPhone[contactAmount] = scanner.nextLine();
                                    contactAmount++;
                                    System.out.println("Contact added successfully!");
                                } else {
                                    System.out.println("Contact list is full!");
                                }
                                break;
                            case "n":
                                break;
                            default:
                                System.out.println("Invalid input!");
                        }
                    break;
                case 2:
                    System.out.println("Option " + choice + " chosen. Please wait a moment...");
                    System.out.println("Welcome to the contact list!");
                    if (contactAmount == 0) {
                        System.out.println("No contacts to display.");
                    } else {
                        for (int i = 0; i < contactAmount; i++) {
                            System.out.println((i + 1) + ". " + contactName[i] + " | " + contactPhone[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Option " + choice + " chosen. Please wait a moment...");
                    System.out.println("Welcome to the contact modification center!");

                    if (contactAmount == 0) {
                        System.out.println("No contacts available to modify.");
                    } else {
                        System.out.print("Enter name of contact to modify: ");
                        scanner.nextLine();
                        String modifyName = scanner.nextLine();

                        boolean found = false;
                        for (int i = 0; i < contactAmount; i++) {
                            if (contactName[i].equalsIgnoreCase(modifyName)) {
                                System.out.println("Contact found: " + contactName[i] + " | " + contactPhone[i]);
                                System.out.println("Enter new name (or press Enter to keep current): ");
                                String newName = scanner.nextLine();
                                System.out.println("Enter new phone number (or press Enter to keep current): ");
                                String newPhone = scanner.nextLine();

                                if (!newName.isEmpty()) { // if user presses enter then it keeps the previous info
                                    contactName[i] = newName;
                                }
                                if (!newPhone.isEmpty()) {
                                    contactPhone[i] = newPhone;
                                }

                                System.out.println("Contact modified successfully!");
                                System.out.println("Updated contact: " + contactName[i] + " | " + contactPhone[i]);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Contact not found.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Option " + choice + " chosen. Exiting program...");
                    loop = false;
                    break;
            }
        }
    }
}
