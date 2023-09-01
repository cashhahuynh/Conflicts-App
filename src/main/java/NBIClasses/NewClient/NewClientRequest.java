package NBIClasses.NewClient;

import DataManagement.LinkedListConflicts;
import StaticMethods.ConflictsForm;

import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static String description;
    public static NewClient nc;
    public static ConflictsForm conflictsForm;

    public static void newClient() {

        generateNBIForm();
        finalFormView();

    }

    private static void generateNBIForm() {

        conflictsForm.addParties(scanner);
        scanner.nextLine();

        System.out.println("\nWhat is the description of matter? ");
        description = scanner.nextLine();

        nc = new NewClient(conflictsForm.clientNameList, conflictsForm.list, 1, description, true);

    }

    private static void deleteNBIForm() {
        nc = new NewClient();
        conflictsForm.reset();

        System.out.println("\nPLEASE ENTER ALL INFORMATION FOR YOUR NEW CLIENT REQUEST: ");
        NewClientRequest.newClient();
    }

    private static void submitNBIForm() {
        conflictsForm.runConflicts();
        scanner.close();
    }

    private static void correctNBIForm() {
        System.out.println("\nPlease select the following to correct:" +
                "\n1. Additional parties to be searched" +
                "\n2. Change description of matter");
        if (scanner.nextInt() == 1) {
            conflictsForm.addParties(scanner);
        } else {
            System.out.println("\nWhat is the updated description of matter?");
            System.out.printf("current description of matter: %s\n", description);
            scanner.nextLine();
            description = scanner.nextLine();
            nc = new NewClient(conflictsForm.clientNameList, conflictsForm.list, 1, description, true);
        }

        finalFormView();

    }

    private static void finalFormView() {

        System.out.println("\n* * * * * * * * * * NBI FORM * * * * * * * * * *");
        System.out.printf("\nCLIENT NAME: %S" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", nc.getClientName(), nc.getDescription(), nc.getConflictSearch());

        System.out.println("\nPARTIES TO BE SUBMITTED FOR CONFLICT SEARCH: ");
        LinkedListConflicts.display(conflictsForm.list.head);

        System.out.println("\n* * * * * * * * * * NBI FORM * * * * * * * * * *");

        finalFormSelection();

    }

    private static void finalFormSelection() {
        boolean complete = false;
        do {
            System.out.println("\nPlease select following options before completing your form:" +
                    "\n1. Delete form" +
                    "\n2. Submit form" +
                    "\n3. Correct form");
            switch(scanner.nextInt()) {
                case 1:
                    deleteNBIForm();
                    complete = true;
                    break;
                case 2:
                    submitNBIForm();
                    complete = true;
                    break;
                case 3:
                    correctNBIForm();
                    complete = true;
                    break;
                default:
                    System.out.println("Not a valid selection. Please try again.");
            }
        } while (complete == false);
    }

}