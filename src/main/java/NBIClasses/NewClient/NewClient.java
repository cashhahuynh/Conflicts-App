package NBIClasses.NewClient;

import AbstractClass.NBI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewClient extends NBI {

    List<String> clientName;

    public NewClient(List<String> clientName, int NBI, String description, Boolean conflictSearch) {
        super(NBI, description, true);
        this.clientName = clientName;
    }

    //trying to figure out how to remove last /
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

    @Override
    public String toString() {

        String str = String.format("Client name: %s" +
                "\nDescription of matter: %s" +
                "\nConflict search required: %b", getClientName(), getDescription(), getConflictSearch());

        return str;
    }
}
