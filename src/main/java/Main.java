import NBIClasses.NewClient.NewClientRequest;
import NBIClasses.NewMatter.NewMatterRequest;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] arg) {

        System.out.println("\nEnter number of request type: ");
        System.out.println("1. New Client");
        System.out.println("2. New Matter for Existing Client");

        boolean exit = false;

        do {
            switch(scanner.nextInt()) {
                case 1:
                    NewClientRequest.newClient();
                    exit = true;
                    break;
                case 2:
                    NewMatterRequest.newMatter();
                    exit = true;
                    break;
                default:
                    System.out.println("That is not a valid choice. Please try again");
                    break;
            }
        } while (exit == false);

        //NewMatterRequest.findClientName();

    }

}
