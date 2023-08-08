package NBIClasses.NewMatter;

import StaticMethods.RunConflicts;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NewMatterRequest {

    public static Scanner scanner = new Scanner(System.in);
    public static Boolean bool;
    public static int clientNumber;
    public static String clientName;
    public static String description;
    public static int conflictSearchID;
    public static NewMatter nm;
    public static RunConflicts<NewMatter> obj;
//    private static boolean isDataLoaded = false;

    public static void newMatter() {

        generateNBIForm();
        locateClientName(clientNumber);
        isConflictSearchRequired(conflictSearchID);

        System.out.printf("\nCLIENT NUMBER: %d (%S)" +
                "\nDESCRIPTION OF MATTER: %S" +
                "\nCONFLICT SEARCH REQUIRED: %B\n", obj.getObj().getClientNumber(), clientName, obj.getObj().getDescription(), obj.getObj().getConflictSearch());

        newMatterConflictSearch(obj);

    }

    public static void generateNBIForm() {

        System.out.println("What is the client number? ");
        clientNumber = scanner.nextInt();

        scanner.nextLine();

        System.out.println("What is the description of matter?: ");
        description = scanner.nextLine();
        System.out.println("Are there parties involved in the matter?: " +
                "\n1. Yes" +
                "\n2. No");

        conflictSearchID = scanner.nextInt();
        scanner.close();

        nm = new NewMatter(clientNumber, clientName, 1, description, bool);
        obj = new RunConflicts<>(nm);

    }

    //should create ClientInfo object
    public static void locateClientName(int num) {
        if (num == 1) {
            clientName = "Google";
        } else {
            System.out.println("This client number does not exist.");
        }
    }

    public static void isConflictSearchRequired(int conflictSearchID) {
        if (conflictSearchID == 1) {
            bool = true;
        } else {
            bool = false;
        }
    }

    public static void newMatterConflictSearch(RunConflicts<NewMatter> newMatter) {
        RunConflicts.runConflicts(newMatter);
    }

//    //reads CSV file
//    public static void findClientName() throws IOException {
//
//        if(isDataLoaded) {
//            return;
//        }
//
//        try {
//
//            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/client.csv"));
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//
//            for (CSVRecord csvRecord : csvParser) {
//                int number = Integer.parseInt(csvRecord.get(0));
//                String name = csvRecord.get(1);
//                Boolean active = Boolean.valueOf(csvRecord.get(2));
//
//                System.out.println("Record no: " + csvRecord.getRecordNumber());
//                System.out.println("Number: " + number);
//                System.out.println("Name: " + name);
//                System.out.println("Active: " + active);
//
//            }
//
//            isDataLoaded = true;
//
//        } catch(IOException e) {
//            System.out.println("Failed to load data");
//            e.printStackTrace();
//        }
//
//    }

}
