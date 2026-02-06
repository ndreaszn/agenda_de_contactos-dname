import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    private static String[] contactName = new String[100];
    private static String[] contactPhone = new String[100];
    private static int contactAmount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    showContacts();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    exitProgram();
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose from 1-4.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("1. Add contact");
        System.out.println("2. Show contacts");
        System.out.println("3. Modify contact");
        System.out.println("4. Exit");
        System.out.print("Choose from 1-4: ");
    }

    private static void addContact() {
        System.out.println("Option 1 chosen. Please wait a moment...");
        System.out.println("Welcome to the contact addition center!");
        System.out.println();
        System.out.println("Would you like to add a contact? (y/n)");
        scanner.nextLine();
        String addContactChoice = scanner.nextLine();

        switch (addContactChoice) {
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
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private static void showContacts() {
        System.out.println("Option 2 chosen. Please wait a moment...");
        System.out.println("Welcome to the contact list!");

        if (contactAmount == 0) {
            System.out.println("No contacts to display.");
        } else {
            for (int i = 0; i < contactAmount; i++) {
                System.out.println((i + 1) + ". " + contactName[i] + " | " + contactPhone[i]);
            }
        }
    }

    private static void modifyContact() {
        System.out.println("Option 3 chosen. Please wait a moment...");
        System.out.println("Welcome to the contact modification center!");

        if (contactAmount == 0) {
            System.out.println("No contacts available to modify.");
            return;
        }

        System.out.print("Enter name of contact to modify: ");
        scanner.nextLine();
        String modifyName = scanner.nextLine();

        int contactIndex = findContactByName(modifyName);

        if (contactIndex != -1) {
            updateContactInfo(contactIndex);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static int findContactByName(String name) {
        for (int i = 0; i < contactAmount; i++) {
            if (contactName[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; // not found
    }

    private static void updateContactInfo(int index) {
        System.out.println("Contact found: " + contactName[index] + " | " + contactPhone[index]);
        System.out.println("Enter new name (or press Enter to keep current): ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number (or press Enter to keep current): ");
        String newPhone = scanner.nextLine();

        if (!newName.isEmpty()) {
            contactName[index] = newName;
        }
        if (!newPhone.isEmpty()) {
            contactPhone[index] = newPhone;
        }

        System.out.println("Contact modified successfully!");
        System.out.println("Updated contact: " + contactName[index] + " | " + contactPhone[index]);
    }

    private static void exitProgram() {
        System.out.println("Option 4 chosen. Exiting program...");
    }
}