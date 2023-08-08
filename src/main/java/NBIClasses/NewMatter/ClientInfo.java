package NBIClasses.NewMatter;

public class ClientInfo {

    int clientNumber;
    String clientName;
    Boolean active;

    public ClientInfo(int clientNumber, String clientName, Boolean active) {
        this.clientNumber = clientNumber;
        this.clientName = clientName;
        this.active = active;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String str = String.format("%s (%d): %b", clientName, clientNumber, active);
        return str;
    }
}
