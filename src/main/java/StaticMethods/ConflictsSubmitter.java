package StaticMethods;

import DataManagement.LinkedListConflicts;

public class ConflictsSubmitter {

    //this method will handle returning conflicts results
    public static void runConflicts(LinkedListConflicts list) {
        System.out.println("\nThanks for submitting. We will run a search and generate a report shortly for the parties below.");
        LinkedListConflicts.display(list.head);
    }

}
