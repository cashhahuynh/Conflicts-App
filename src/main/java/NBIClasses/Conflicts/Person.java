package NBIClasses.Conflicts;

import AbstractClass.Relationship;

public class Person extends Relationship {

    String lastName, firstName;

    public Person(String lastName, String firstName, String relationship) {
        super(relationship);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
