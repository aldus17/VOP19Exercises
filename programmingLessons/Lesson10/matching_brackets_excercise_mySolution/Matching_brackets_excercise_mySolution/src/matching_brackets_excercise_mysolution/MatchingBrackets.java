    package matching_brackets_excercise_mysolution;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author erso
 */
public class MatchingBrackets {

    public boolean ckeckBrackets(String expression) {
        Stack<Character> bracketStack;
        bracketStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char charachter = expression.charAt(i);
            char openChar = 0;
            //|| charachter == ']' || charachter == ')' || charachter == '}'
            if (charachter == '{' || charachter == '(' || charachter == '[') {
                bracketStack.push(charachter);

            } else if (charachter == ']' || charachter == ')' || charachter == '}') {

                if (bracketStack.isEmpty()) {
                    return false;
                }

                openChar = bracketStack.pop();
                if (!(openChar == '[' && charachter == ']'
                        || openChar == '(' && charachter == ')'
                        || openChar == '{' && charachter == '}')) {
                    System.out.println("test");
                    return false;
                }
            }

        }
        return bracketStack.isEmpty();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if (!expression.equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q"));
    }
}
