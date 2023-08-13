package NBIClasses.NewClient;

import StaticMethods.Format;
import StaticMethods.RunConflicts;

import java.util.Scanner;

public class NewClientRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static int clientType;
    public static String clientName;
    public static String description;
    public static NewClient nc;
    public static RunConflicts<NewClient> obj;
    public static Format clientFormatTest;

    public static void newClient() {

        generateNBIForm();

        System.out.printf("\nCLIENT NAME: %S" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", obj.getObj().getClientName(), obj.getObj().getDescription(), obj.getObj().getConflictSearch());

        newClientConflictSearch(obj);

    }

    public static void generateNBIForm() {

//        System.out.println("Please select client type:" +
//                "\n1. Person" +
//                "\n2. Company");
//
//        clientType = scanner.nextInt();
//
//        formatClientTest(clientType);
//
//        scanner.nextLine();

        System.out.println("What is the client name?");

        clientName = scanner.nextLine();

        System.out.println("What is the description of matter? ");
        description = scanner.nextLine();
        scanner.close();

        //changed field in NewClient class to type Format
        nc = new NewClient(clientName, 1, description, true);
        obj = new RunConflicts<>(nc);

    }

    //how to store formatted name?
    public static void formatClientTest(int clientType) {
        if (clientType == 1) {
            Format.format(clientType, clientName);
            clientFormatTest = new Format(Format.getFormattedName());
        }
        if (clientType == 2) {
            Format.format(clientType, clientName);
            clientFormatTest = new Format(Format.getFormattedName());
        }
    }

    public static void newClientConflictSearch(RunConflicts<NewClient> newClient) {
        RunConflicts.runConflicts(newClient);
    }

}
