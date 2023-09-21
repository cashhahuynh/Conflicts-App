package StaticMethods;

import DataManagement.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class ConflictsSubmitter {

    private static int hits;
    private static final List<Object> toSearchList = new ArrayList<>();
    private static final List<String> conflictsReportList = new ArrayList<>();

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

    private static void searchDataBase() {
        System.out.println("searchDataBase method being called: purpose is to search in database before adding new search");
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
