package NBIClasses.Conflicts;

public class ConflictsInfo {

    String lastNameOrCompanyName, firstName;
    int relationship;

    public ConflictsInfo(String lastNameOrCompanyName, String firstName, int relationship) {
        this.lastNameOrCompanyName = lastNameOrCompanyName;
        this.firstName = firstName;
        this.relationship = relationship;
    }

    public String getLastNameOrCompanyName() {
        return lastNameOrCompanyName;
    }

    public void setLastNameOrCompanyName(String lastNameOrCompanyName) {
        this.lastNameOrCompanyName = lastNameOrCompanyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }
}
