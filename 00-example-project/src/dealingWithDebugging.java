/*
 * TODO - Add your name!
 * 10/26/2017
 *
 * Description: Debugging examples used to practice Java debugging in CS 1101.
 */

import java.util.Scanner;

public class dealingWithDebugging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testString = "Yoooooo!!!!! That was soooooo dope!!!!!!!!!!!! OMG!!! THANKU!!!!";
        String caesar = "1316 1926 0914 0526 0502";

        // First, let's figure out where our crashes happen and fix some String problems
        //locationDebugging(testString);
        //System.out.println();

        // Now it's time to see some tricky loops
        //loopDebugging(caesar, 4);
        //System.out.println();

        // But wait - there's more! Time for some nested loops
        //nestedLoopDebugging();
        //System.out.println();

        // Finally, let's test your true skills with some booleans
        booleanDebugging(scanner);
    }

    /**
     * Example for finding the location of a program crash
     */
    private static void locationDebugging(String userString) {
        // Let's play with some substrings. TODO - This breaks! Can you fix it?
        System.out.println(userString.substring(0, userString.length()));

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
        while (i <= userString.length() - 1) {
            if (userString.charAt(i) != '!') {
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

        // Walk down entire string.
        while (i <= text.length() - 1) {
            // Skip blanks
            if ((text.charAt(i) == ' ')) {
                ++i; // TODO - What's wrong with our increment?
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
        int height = 3;

        // Nested loop to print the triangle.
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(symbol);
                //System.out.println();
            }
            System.out.println();
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
        while (userChoice == 'W' || userChoice == 'N' || userChoice == 'D' ||  userChoice != 'Q') {
            System.out.print("Choose a valid menu option: ");
            userChoice = Character.toUpperCase(scanner.nextLine().charAt(0));
        }

        // This should print whenever you've fixed the error above
        System.out.println("We finally exited the loop!");
    }
}
