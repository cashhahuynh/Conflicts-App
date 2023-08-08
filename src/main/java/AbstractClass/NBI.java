package AbstractClass;

public abstract class NBI {

    int NBI;
    String description;
    Boolean conflictSearch;

    public NBI(int NBI, String description, Boolean conflictSearch) {
        this.NBI = NBI;
        this.description = description;
        this.conflictSearch = conflictSearch;
    }

    public NBI() {}

    public int getNBI() {
        return NBI;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getConflictSearch() {
        return conflictSearch;
    }

}
