package StaticMethods;

public class Format {

    private static String formattedName;

    public static String formatPerson(String first, String last) {
        formattedName = last + ", " + first;
        return formattedName;
    }
//
    //create more static methods to format municipalities and gov't entities

    public static String getFormattedName() {
        return formattedName;
    }
}
