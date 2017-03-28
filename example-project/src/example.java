import java.util.Scanner;

public class example {
    public static void main(String[] args) {
        // Style example
        int x = badstyle(4, 5);
        System.out.printf("Style number: %d\n", x);

        // Debugging example
        Scanner console = new Scanner(System.in);
        String question = "Please enter a valid number: ";
        String error = "Uh oh!";
        int y = getNumber(console, question, error);
        System.out.printf("Debugging number: %d\n", y);
    }

    /*
     * *************
     * STYLE EXAMPLE
     * *************
     */
    public static int badstyle(int x, int y) {
        // This is a for loop that runs a total of two times. Each time it runs, it increments i, its counter.
        // the for loop then multiplies x by itself and y by itself on lines 21 and 22 in body of the loop.
        for (int i = 0; i < 2; i++) {
            x *= x; // x equals x times x
            y *= y; // y equals y times y
        } // for loop

        return x + y;


    }

    /*
     * *************
     * DEBUG EXAMPLE
     * *************
     */

    /**
     * getNumber - Asks user to enter a number until a valid one is entered.
     *
     * @param sc       : Reads in user input
     * @param question : question to ask user
     * @return : number
     */
    private static int getNumber(Scanner sc, String question, String errMsg) {
        String s;
        boolean endLoop;
        int value = 0;
        System.out.print(question);
        do {
            s = sc.nextLine().trim();
            endLoop = false;
            if (!isSignedInteger(s)) {
                value = Integer.parseInt(s);
                endLoop = (value > 0 || value == -1);
            }
            System.out.println();
            if (!endLoop) {
                System.out.println(s + "\n" + errMsg);
                System.out.println();
                System.out.print(question);
            }
        } while (!endLoop);
        return value;
    }

    /**
     * Determines if a string is a signed number
     *
     * @param s : string
     * @return : true <=> it is a signed number
     */
    private static boolean isSignedInteger(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }

        //If starts with - then remove sign
        if (s.startsWith("-")) {
            s = s.substring(1);
            if (s.isEmpty()) {
                return false;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}