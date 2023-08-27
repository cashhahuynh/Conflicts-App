package StaticMethods;

import DataManagement.LinkedListConflicts;
import NBIClasses.Conflicts.Company;
import NBIClasses.Conflicts.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConflictsForm {

    public static LinkedListConflicts list = new LinkedListConflicts();
    public static Company company;
    public static Person person;
    public static List<String> clientNameList = new ArrayList<>();

    static {
        list.head = null;
    }

    public static void addParties(Scanner scanner) {

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
            String first, last, companyName, designation = "";
            int partyID = scanner.nextInt();

            switch(partyID) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\nWhat is the party's first name?");
                    first = scanner.nextLine();

                    System.out.println("What is the party's last name?");
                    last = scanner.nextLine();

                    System.out.println("What is the party's involvement?");
                    designation = designationHandler(scanner.nextLine(), scanner, partyID, first, last, "");
                    list.head = list.insertInEnd(person = new Person(last, first, designation), list.head);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("\nWhat is the party's name?");
                    companyName = scanner.nextLine();

                    System.out.println("What is this party's involvement?");
                    designation = designationHandler(scanner.nextLine(), scanner, partyID, "", "", companyName);
                    list.head = list.insertInEnd(company = new Company(companyName, designation), list.head);
                    break;
                case 3:
                    complete = true;
            }

        } while (complete == false);

    }

    public static String designationHandler(String d, Scanner scanner, int partyID, String first, String last, String companyName) {

        boolean correctDesignation = true;

        switch(d.toUpperCase()) {
            case "CLIENT":
                d = "CLIENT";
                if (partyID == 1) {
                    addClientToDisplay(Format.formatPerson(first, last));
                } else {
                    addClientToDisplay(companyName);
                }
                break;
            case "CLIENT RELATED":
                d = "CLIENT RELATED";
                break;
            case "CLIENT ON BEHALF OF":
                d = "CLIENT/ON BEHALF OF";
                break;
            case "ADVERSE":
                d = "ADVERSE";
                break;
            case "OTHER INVOLVED":
                d = "OTHER INVOLVED";
                break;
            default:
                System.out.println("Not valid input. Please enter acceptable party involvement.");
                correctDesignation = false;
        }

        if (!correctDesignation) {
            d = scanner.nextLine();
            d = designationHandler(d, scanner, partyID, first, last, companyName);
        }

        return d;

    }

    public static void addClientToDisplay(String clientName) {
        clientNameList.add(clientName);
    }

    public static void runConflicts() {
        ConflictsSubmitter.runConflicts(list);
    }

    public static void reset() {
        list = new LinkedListConflicts();
        clientNameList = new ArrayList<>();
    }

}
