package NBIClasses.NewClient;

import AbstractClass.NBI;

public class NewClient extends NBI {

    String clientName;

    public NewClient(String clientName, int NBI, String description, Boolean conflictSearch) {
        super(NBI, description, true);
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {

        String str = String.format("Client name: %s" +
                "\nDescription of matter: %s" +
                "\nConflict search required: %b", getClientName(), getDescription(), getConflictSearch());

        return "";
    }
}
