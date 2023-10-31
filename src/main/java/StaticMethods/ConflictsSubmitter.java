package StaticMethods;

import DataManagement.LinkedListNode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConflictsSubmitter {

    private static int hits;
    private static final List<Object> toSearchList = new ArrayList<>();
    private static final List<String> conflictsReportList = new ArrayList<>();
    private static BufferedReader br;

    public static void conflictSubmitter(LinkedListNode head) {

        newList(head);
        generateCurrentSearch();
        searchDataBase();
        addToDataBase();
        generateConflictReport();

    }

    private static void newList(LinkedListNode head) {
        LinkedListNode ll = head;

        while(!(ll == null)) {
            toSearchList.add(ll.data);
            ll = ll.next;
        }
    }

    //to work on: csv reader splits individual names...
    private static void searchDataBase() {
        System.out.println("searchDataBase method being called: purpose is to search in database before adding new search\n");
        System.out.println("Conflicts database from CSV test:");

        String line = "";
        String splitBy = ",";
        int counter = 0;

        //to do 1: compare database with names and store hits in new list
        //to do 2: organize hits based on designation then names? comparator/comparable?
        try {
            br = new BufferedReader(new FileReader("/Users/cash/Downloads/Conflicts App/src/main/resources/conflictsDataBase.csv"));
            while ((line = br.readLine()) != null) {
                counter++;
                String [] list = line.split(splitBy);
                if (list[1] == "") {
                    System.out.printf("Party %d: " + list[0] + " / Involvement: " + list[1] + "\n", counter);
                } else {
                    System.out.printf("Party %d: " + list[0] + " " + list[1] + " / Involvement: " + list[2] + "\n", counter);
                }
            }
        } catch (IOException o) {
            o.printStackTrace();
        }

    }

    private static void addToDataBase() {
        System.out.println("addToDataBase method being called: purpose is to add to existing database");

    }

    private static void generateCurrentSearch() {
        System.out.println("\nThanks for submitting. We will run a search and generate a report shortly for the parties below.");

        for (Object i : toSearchList) {
            System.out.println(i);
        }
    }

    public static void generateConflictReport() {
        System.out.println("generateConflictReport method being called: purpose is to return conflict report with matches");
    }

}
