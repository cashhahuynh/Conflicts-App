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
//    private static List<String> filteredList;

    public static void conflictSubmitter(LinkedListNode head) {

        newList(head);
        generateCurrentSearch();
//        initializeFilteredList();
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
        System.out.println("searchDataBase method being called: purpose is to search in database before adding new search\n");

        String line = "";
        String splitBy = ",";
        hits = 0;

        //to do 1: compare database with names and store hits in new list
        //to do 2: organize hits based on designation then names? comparator/comparable?

        //idea 1.1: loop through toSearchList and compare to CSV file, if a match add to conflictsReportList
        //idea 1.2: use pattern and matcher classes on filteredList so report can return main keywords
        for (int i = 0; i < toSearchList.size(); i++) {
            //want to get it to print only name, not toString method from Person and Company classes which prints designation and name
            System.out.println("test: " + toSearchList.get(i));
        }

        //csv reader to live in for loop above putting here to test performance
        try {
            br = new BufferedReader(new FileReader("/Users/cash/Downloads/Conflicts App/src/main/resources/conflictsDataBase.csv"));
            while ((line = br.readLine()) != null) {
                String [] list = line.split(splitBy);

                if (list[0].startsWith("#")) {
                    //do nothing
                } else if (list[1].isEmpty()) {
                    hits++;
                    System.out.printf("Hit %d: %s (%s) \n", hits, list[0].toUpperCase(), list[2].toUpperCase());
                } else {
                    hits++;
                    System.out.printf("Hit %d: %s, %s (%s) \n", hits, list[1].toUpperCase(), list[0].toUpperCase(), list[2].toUpperCase());
                }

            }
        } catch (IOException o) {
            o.printStackTrace();
        }

    }

    //might have to scrap method because app is static and i'm not using relational database yet
    private static void addToDataBase() {
        System.out.println("\naddToDataBase method being called: purpose is to add to existing database");

    }

    private static void generateCurrentSearch() {
        System.out.println("\nThanks for submitting. We will run a search and generate a report shortly for the parties below.");

        for (Object i : toSearchList) {
            System.out.println(i);
        }
    }

    public static void generateConflictReport() {
        System.out.println("\ngenerateConflictReport method being called: purpose is to return conflict report with matches");
        System.out.printf("Total hits: %d\n", hits);
    }

    //work on method later to help filter generic terms from search so that report returns important keywords
//    public static void initializeFilteredList () {
//        filteredList = new ArrayList<>();
//        filteredList.add("limited");
//        filteredList.add("company");
//        filteredList.add("limited liability company");
//        filteredList.add("limited liability partnership");
//    }

}
