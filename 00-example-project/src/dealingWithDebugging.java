/*
 * // TODO - Add your name!
 * 10/26/2017
 *
 * Description: Debugging examples used to practice Java debugging in CS 1101.
 */

import java.util.Scanner;

public class dealingWithDebugging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testString = "Yoooooo!!!!! That was soooooo dope!!!!!!!!!!!! OMG!!! THANKU!!!!";

        // First, let's figure out where our crashes happen and fix some String problems
        //locationDebugging(testString);

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

        // Loop through every character in userString
        while (i < userString.length()) {
            if (userString.charAt(i) != '!') {
                // TODO - We've made a String indexing error. Can you find it?
                i++;
                tempStr += userString.charAt(i);
            } else {
                while ((i < userString.length()) && (userString.charAt(i) == '!')) {
                    i++;
                }

                tempStr += '!';
            }
        }

        // Replace exclamation points with periods
        tempStr = tempStr.replace("!", ".");

        // Print out corrected String
        System.out.println("Corrected: " + tempStr);
    }

    /**
     * Example for debugging loop errors
     * Similar to PA06-A - A Caesar Cipher's decode() method
     */
    private static void loopDebugging(String text, int shift) {
        String decipheredMessage = "";
        int i = 0;

        // Walk down entire string. TODO - What's wrong with our counter?
        while (i <= text.length()) {
            // Skip blanks
            if ((text.charAt(i) == ' ')) {
                ++i;
            }

            // Pull two characters off text
            String digString = text.substring(i, i + 2);

            // Convert two digit string to an integer
            int digits = Integer.parseInt(digString) - shift + 96;

            // Convert integer code to a character
            char letter = (char) digits;

            // If shift is not in lowercase alphabet, adjust
            if (letter < 'a') {
                letter = (char) (letter + 26);
            }

            // Attach to our deciphered result
            decipheredMessage += letter;

            //move onto next two digit sequence
            i += 2;
        }

        System.out.println("Deciphered: " + decipheredMessage);
    }

    /**
     * Example for debugging nested loop errors
     * Similar to PA03-A - Which Way is Up?
     */
    private static void nestedLoopDebugging() {
        // Feel free to change these!
        char symbol = '*';
        int height = 5;

        // Nested loop to print the triangle. TODO - Can you find the errors?
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; i++) {
                System.out.print(symbol);
                System.out.println();
            }
        }
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
