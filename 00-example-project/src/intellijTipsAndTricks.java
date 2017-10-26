import java.util.Scanner;

public class intellijTipsAndTricks {
    public static void main(String[] args) {
        // Prompt for user input
        Scanner console = new Scanner(System.in);
        System.out.println("What word would you like to use to debug?");
        String str = console.nextLine();

        debuggingExample(str);
    }

    /*
     * badStyleExample - this does x y and z
     */
    private static void badStyleExample() {
        System.out.println();

        for (int i = 0; i < 4; i++) {
            debuggingExample("hello");
        }
    }

    /**
     * badstyleexampl2 - an example of BAD style
     */
    private static void badstyleexampl2() {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            debuggingExample("hello");
        }
    }

    /**
     * debuggingExample - helps demonstrate basic functionality of a debugger
     */
    private static void debuggingExample(String str) {
        char[] arr = str.toCharArray(); // Converts str to a char[]

        // Iterate through arr and do something fun with every char
        for (char c : arr) {
            debuggingHelper(c);
        }
    }

    /**
     * debuggingHelper - helper function for debuggingExample()
     */
    private static void debuggingHelper(char c) {
        System.out.println("Ooh wee, Rick, I'm helping with the letter " + c + "!");
    }
}
