package Home_Assignment_8;
import java.util.*;
public class LC_901_Online_Stock_Span {
    private Stack<int[]> stack;

    public LC_901_Online_Stock_Span() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add popped span
        }
        stack.push(new int[]{price, span}); // Store price and span
        return span;
    }
}