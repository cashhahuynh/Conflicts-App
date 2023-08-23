package NBIClasses.NewClient;

import AbstractClass.NBI;
import DataManagement.LinkedListConflicts;

import java.util.List;

public class NewClient extends NBI {

    List<String> clientName;
    LinkedListConflicts l;

    public NewClient(List<String> clientName, LinkedListConflicts l, int NBI, String description, Boolean conflictSearch) {
        super(NBI, description, true);
        this.clientName = clientName;
        this.l = l;
    }

    public NewClient() {}

    public String getClientName() {

        String displayName;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < clientName.size(); i ++) {
            sb.append(clientName.get(i) + " / ");
        }

        displayName = sb.toString().trim();

        if (displayName.endsWith("/")) {
            displayName = displayName.substring(0, displayName.length() - 1);
        }

        return displayName;
    }

    public void setClientName(List<String> clientName) {
        this.clientName = clientName;
    }

    public LinkedListConflicts getL() {
        return l;
    }

    public void setL(LinkedListConflicts l) {
        this.l = l;
    }

    @Override
    public String toString() {

        String str = String.format("Client name: %s" +
                "\nDescription of matter: %s" +
                "\nConflict search required: %b", getClientName(), getDescription(), getConflictSearch());

        return str;
    }
}
