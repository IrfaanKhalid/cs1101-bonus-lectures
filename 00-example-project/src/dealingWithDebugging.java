/*
 * // TODO - Change to your name
 * Irfaan Khalid
 * 10/26/2017
 *
 * Description: Debugging examples used to practice Java debugging in CS 1101.
 */

import java.util.Scanner;

public class dealingWithDebugging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testString = "Yoooooo!!!!! That was soooooo dope!!!!!!!!!!!! OMG!!! THANKU!!!!";

        // First, let's figure out where our crashes happen
        locationDebugging(testString);

        // Now that we've got a location, let's try to play with some String debugging
        //stringDebugging();

        // Now it's time to see some tricky loops
        //loopDebugging();

        // But wait - there's more! Time for some nested loops
        //nestedLoopDebugging();

        // Finally, let's test your true skills with some booleans
        //booleanDebugging(scanner);
    }

    /**
     * Example for finding the location of a program crash
     */
    private static void locationDebugging(String userString) {
        // Let's start by printing our original String
        System.out.println(userString + "\n");

        // Let's play with some substrings. TODO - This breaks! Can you fix it?
        System.out.println(userString.substring(0, userString.length() + 1));

        // Phew. We figured that one out. TODO - Can you find the location of the next crash?
        stringDebugging(userString);
    }

    /**
     * Example for debugging String indexing errors
     * Similar to PA06-07-B - The Minaj Tweet Manager's deEmphasizer() method
     */
    private static void stringDebugging(String userString) {
        String tempStr = "";
        int i = 0;

        // TODO - Our loop doesn't work correctly. Can you fix it?
        while (i <= userString.length()) {
            if (userString.charAt(i) != '!') {
                // TODO - What's wrong with how we increment i?
                i++;
                tempStr += userString.charAt(i);
            }
            else {
                while ((i < userString.length()) &&  (userString.charAt(i) == '!')) {
                    i++;
                }

                tempStr += '!';
            }
        }

        // Replace exclamation points with periods
        tempStr = tempStr.replace("!", ".");

        System.out.println(tempStr);
    }

    /**
     * Example for debugging loop errors
     */
    private static void loopDebugging() {

    }

    /**
     * Example for debugging nested loop errors
     */
    private static void nestedLoopDebugging() {

    }

    /**
     * Example for debugging boolean logic errors
     * Similar to PA06-07-B - The Minaj Tweet Manager's getMenuChoice() method
     */
    private static void booleanDebugging(Scanner scanner) {
        // Default initialization
        char userChoice = '\u0000';

        // Print menu information to console for the user
        System.out.println();
        System.out.println("MAIN MENU - Choose one of the following");
        System.out.println();
        System.out.println("(W)ord count");
        System.out.println("(N)ickterpreter");
        System.out.println("(D)e-Emphasizer");
        System.out.println("(Q)uit");
        System.out.println();

        // TODO - We can't quit out of this loop. Can you fix the bug?
        while (userChoice != 'W' || userChoice != 'N' || userChoice != 'D' || userChoice != 'Q') {
            System.out.print("Choose a valid menu option: ");
            userChoice = Character.toUpperCase(scanner.nextLine().charAt(0));
        }

        // This should print whenever you've fixed the error above
        System.out.println("We finally exited the loop!");
    }
}
