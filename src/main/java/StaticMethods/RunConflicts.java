package StaticMethods;

import DataManagement.LinkedListConflicts;
import NBIClasses.Conflicts.Company;
import NBIClasses.Conflicts.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunConflicts {

    public static LinkedListConflicts list;
    public static Company company;
    public static Person person;
    public static List<String> clientNameList = new ArrayList<>();

    public static void addParties(Scanner scanner) {
        list = new LinkedListConflicts();
        list.head = null;

        boolean complete = false;
        do {
            System.out.println("\nCurrent conflict searches: ");
            if (list.head == null) {
                System.out.println("NO PARTIES HAVE BEEN ADDED YET");
            } else {
                LinkedListConflicts.display(list.head);
            }

            System.out.println();
            System.out.println("Please submit parties: ");
            System.out.println("1. Add person");
            System.out.println("2. Add company");
            System.out.println("3. No more parties to add");
            String first, last, companyName, designation;

            switch(scanner.nextInt()) {
                case 1:
                    scanner.nextLine();
                    System.out.println("What is the party's first name?");
                    first = scanner.nextLine();

                    System.out.println("What is the party's last name?");
                    last = scanner.nextLine();

                    System.out.println("What is the party's involvement?");
                    designation = scanner.nextLine();
                    list.head = list.insertInEnd(person = new Person(last, first, designation), list.head);

                    if (designation.equalsIgnoreCase("client")) {
                        addClientToDisplay(Format.formatPerson(first, last));
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("What is the party's name?");
                    companyName = scanner.nextLine();

                    System.out.println("What is this party's involvement?");
                    designation = scanner.nextLine();
                    list.head = list.insertInEnd(company = new Company(companyName, designation), list.head);

                    if (designation.equalsIgnoreCase("client")) {
                        addClientToDisplay(companyName);
                    }
                    break;
                case 3:
                    complete = true;
            }

        } while (complete == false);

    }

    public static void addClientToDisplay(String clientName) {
        clientNameList.add(clientName);
    }

    public static void runConflicts() {
        System.out.println("Thanks for submitting. We will run a search and generate a report shortly for the parties below.");
        LinkedListConflicts.display(list.head);
    }

//    public static void reset() {
//        list = new LinkedListConflicts();
//        clientNameList = new ArrayList<>();
//    }

}
