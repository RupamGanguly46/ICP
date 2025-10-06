package Home_Assignment_8;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    // If the token is a number, push it to the stack
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}