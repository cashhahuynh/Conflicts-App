package NBIClasses.Conflicts;

import StaticMethods.RunConflicts;

import java.util.List;

public class ConflictsData<T> {

    List<T>[] arr;

    public ConflictsData(List<T>[] arr) {
        this.arr = arr;
    }

    public List<T>[] getArr() {
        return this.arr;
    }

    public void submitSearch(T[][] arr) {
        RunConflicts.runConflicts(arr);
    }

}
