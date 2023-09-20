package StaticMethods;

import DataManagement.LinkedListConflicts;
import DataManagement.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class ConflictsSubmitter {

    private static int hits;
    private static List<String> toSearchList = new ArrayList<>();
    private static List<String> conflictsReportList = new ArrayList<>();

    //create list from linkedlist object
    public static void runConflicts(LinkedListConflicts list) {
        System.out.println("\nThanks for submitting. We will run a search and generate a report shortly for the parties below.");
        LinkedListConflicts.display(list.head);

        //LinkedListConflicts object calls display method, which takes LinkedListNode as a parameter
        
    }

    //purpose is to search in database before adding new search
    public static void searchDataBase(List<String> list) {
        toSearchList = list;
    }

    //purpose is to add to existing database- create json object and add to json file
    public static void addToDataBase() {

    }

    //will be responsible for returning conflict report
    public static void generateReport() {

    }

}
