import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("1. Add contact");
        System.out.println("2. Show contacts");
        System.out.println("3. Search contact");
        System.out.println("4. Exit");

        System.out.print("Choose from 1-4: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Option " + choice + " chosen. Please wait a moment...");
                System.out.println("Welcome to the contact addition center!");
                break;
            case 2:
                System.out.println("Option " + choice + " chosen. Please wait a moment...");
                System.out.println("Welcome to the contact list!");
                break;
            case 3:
                System.out.println("Option " + choice + " chosen. Please wait a moment...");
                System.out.println("Welcome to the contact search center!");
                break;
            case 4:
                System.out.println("Option " + choice + " chosen. Exiting program...");
                break;
        }
    }
}
