package NBIClasses.NewClient;

import StaticMethods.RunConflicts;

import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static String clientName;
    public static String description;
    public static NewClient nc;
    public static RunConflicts<NewClient> obj;

    public static void newClient() {

        generateNBIForm();

        System.out.printf("\nCLIENT NAME: %S" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", obj.getObj().getClientName(), obj.getObj().getDescription(), obj.getObj().getConflictSearch());

        newClientConflictSearch(obj);

    }

    public static void generateNBIForm() {

        System.out.println("What is the client name?: ");
        clientName = scanner.nextLine();

        System.out.println("What is the description of matter? ");
        description = scanner.nextLine();
        scanner.close();

        nc = new NewClient(clientName, 1, description, true);
        obj = new RunConflicts<>(nc);

    }

    public static void newClientConflictSearch(RunConflicts<NewClient> newClient) {
        RunConflicts.runConflicts(newClient);
    }

}
