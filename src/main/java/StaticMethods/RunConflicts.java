package StaticMethods;

public class RunConflicts<T> {

    T obj;

    public RunConflicts(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }

    //runs search
    public static <T> void runConflicts(T obj) {
        System.out.println("Thanks for submitting. We will run a search and generate a report shortly.");
    }

}
