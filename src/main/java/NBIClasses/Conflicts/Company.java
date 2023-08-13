package NBIClasses.Conflicts;

import AbstractClass.Relationship;

public class Company extends Relationship {

    String company;

    public Company(String company, String relationship) {
        super(relationship);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
