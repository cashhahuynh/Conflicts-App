package StaticMethods;

public class Format {

//    private static int clientType;
//    private static String clientName;
    private static String formattedName;
    
//    public Format(int clientType, String clientName) {
//        this.clientType = clientType;
//        this.clientName = clientName;
//    }

    public Format(String formattedName) {
        this.formattedName = formattedName;
    }

    public static void format(int clientType, String clientName) {
        if (clientType == 1) {
            String [] clientNameArr = clientName.split(" ");
            formattedName = clientNameArr[0] + ", " + clientNameArr[1];
        }
        if (clientType == 2) {
            formattedName = clientName;
        }
    }

    public static String getFormattedName() {
        return formattedName;
    }
}
