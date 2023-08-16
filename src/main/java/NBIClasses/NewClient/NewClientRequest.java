package NBIClasses.NewClient;

import StaticMethods.Format;
import StaticMethods.RunConflicts;

import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static int partyType;
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

        System.out.println("Please select client type:" +
                "\n1. Person" +
                "\n2. Company");
        partyType = scanner.nextInt();

        scanner.nextLine();
        format(partyType);

        System.out.println("What is the description of matter? ");
        description = scanner.nextLine();
        scanner.close();

        nc = new NewClient(clientName, 1, description, true);
        obj = new RunConflicts<>(nc);

    }

    public static void format(int partyType) {
        String first;
        String last;
        if (partyType == 1) {
            System.out.println("What is the client's first name?");
            first = scanner.nextLine();

            System.out.println("What is the client's last name?");
            last = scanner.nextLine();

            clientName = Format.formatPerson(first, last);
        } else {
            System.out.println("What is the client name?");
            clientName = scanner.nextLine();
        }

    }

    public static void newClientConflictSearch(RunConflicts<NewClient> newClient) {
        RunConflicts.runConflicts(newClient);
    }

}
