package NBIClasses.NewClient;

import DataManagement.LinkedListConflicts;
import NBIClasses.Conflicts.Company;
import NBIClasses.Conflicts.Person;
import StaticMethods.Format;
import StaticMethods.RunConflicts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static List<String> clientName = new ArrayList<>();
    public static String description;
    public static NewClient nc;
    public static RunConflicts<NewClient> obj;

    public static Company company;
    public static Person person;

    public static LinkedListConflicts l;

    public static void newClient() {

        generateNBIForm();

        System.out.printf("\nCLIENT NAME: %S" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", nc.getClientName(), nc.getDescription(), nc.getConflictSearch());

        System.out.println("\nPARTIES TO BE SUBMITTED FOR CONFLICT SEARCH: ");
        LinkedListConflicts.display(l.head);

        System.out.println("\nPlease click \"Enter\" to submit.");
        String submit = scanner.nextLine();
        scanner.close();

        if (submit.isEmpty()) {
            newClientConflictSearch(obj);
        }
    }

    public static void generateNBIForm() {

        addParties();

        scanner.nextLine();
        System.out.println("What is the description of matter? ");
        description = scanner.nextLine();

        nc = new NewClient(clientName, 1, description, true);
        obj = new RunConflicts<>(nc);

    }

    public static void addParties() {
        l = new LinkedListConflicts();
        l.head = null;

        boolean complete = false;
        do {

            System.out.println("\nCurrent conflict searches: ");
            if (l.head == null) {
                System.out.println("NO PARTIES HAVE BEEN ADDED YET");
            } else {
                LinkedListConflicts.display(l.head);
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

                    System.out.println("What is this party's involvement?");
                    designation = scanner.nextLine();
                    l.head = l.insertInEnd(person = new Person(last, first, designation), l.head);

                    if (designation.equalsIgnoreCase("client")) {
                        clientName.add(Format.formatPerson(first, last));
                    }

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("What is the party's name?");
                    companyName = scanner.nextLine();

                    System.out.println("What is this party's involvement?");
                    designation = scanner.nextLine();
                    l.head = l.insertInEnd(company = new Company(companyName, designation), l.head);

                    if (designation.equalsIgnoreCase("client")) {
                        clientName.add(companyName);
                    }

                    break;
                case 3:
                    complete = true;
            }
        } while (complete == false);
    }

    public static void newClientConflictSearch(RunConflicts<NewClient> newClient) {
        RunConflicts.runConflicts(newClient);
    }

}