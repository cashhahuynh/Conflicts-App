package StaticMethods;

public class Format {

    private static String formattedName;

    public static String formatPerson(String first, String last) {
        formattedName = last + ", " + first;
        return formattedName;
    }

    public static String getFormattedName() {
        return formattedName;
    }
}
