import java.util.Stack;

public class ReverseStack {

    // Function to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, x);
        stack.push(top);
    }

    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Reverse remaining stack
        reverse(stack);

        // Insert removed element at bottom
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
       
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);
        reverse(stack2);
        System.out.println(stack2); // [1, 2, 3]

        Stack<Integer> stack3 = new Stack<>();
        stack3.push(5);
        reverse(stack3);
        System.out.println(stack3); // [5]

        Stack<Integer> stack4 = new Stack<>();
        stack4.push(-5);
        stack4.push(-10);
        stack4.push(-15);
        reverse(stack4);
        System.out.println(stack4); // [-15, -10, -5]

        Stack<Integer> stack5 = new Stack<>();
        reverse(stack5);
        System.out.println(stack5); // []

        Stack<Integer> stack6 = new Stack<>();
        stack6.push(3);
        stack6.push(3);
        stack6.push(3);
        reverse(stack6);
        System.out.println(stack6); // [3, 3, 3]
    }
}
