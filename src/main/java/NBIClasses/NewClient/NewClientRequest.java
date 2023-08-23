package NBIClasses.NewClient;

import DataManagement.LinkedListConflicts;
import StaticMethods.RunConflicts;

import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static String description;
    public static NewClient nc;

    public static void newClient() {

        generateNBIForm();

        System.out.printf("\nCLIENT NAME: %S" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", nc.getClientName(), nc.getDescription(), nc.getConflictSearch());

        System.out.println("\nPARTIES TO BE SUBMITTED FOR CONFLICT SEARCH: ");
        LinkedListConflicts.display(RunConflicts.list.head);

        System.out.println("\nPlease click \"Enter\" to submit.");
        String submit = scanner.nextLine();
        scanner.close();

        if (submit.isEmpty()) {
            newClientConflictSearch();
        }
    }

    public static void generateNBIForm() {

        RunConflicts.addParties(scanner);
        scanner.nextLine();

        System.out.println("What is the description of matter? ");
        description = scanner.nextLine();

        nc = new NewClient(RunConflicts.clientNameList, RunConflicts.list, 1, description, true);

    }

    public static void newClientConflictSearch() {
        RunConflicts.runConflicts();
    }

//    public static void resetForm() {
//        description = "";
//        nc = new NewClient();
//
//        RunConflicts.reset();
//
//        NewClientRequest.newClient();
//    }

}