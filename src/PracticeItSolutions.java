import java.util.*;

public class PracticeItSolutions {
    public static void interleave(Queue<Integer> queue) {
        if (queue.size() % 2 == 1) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> stack = new Stack<Integer>();
        int size = queue.size();
        for (int i = 0; i < size / 2; i++) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < size; i++) {
            if (i < size / 2) {
                queue.add(queue.remove());
            } else {
                stack.add(queue.remove());
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.remove());
        }
    }
    public boolean isConsecutive(Stack<Integer> stack) {
        if(stack.size() < 2)
            return true;
        Queue<Integer> queue = new LinkedList<Integer>();
        int next = stack.pop();
        queue.add(next);
        boolean consecutive = true;
        while(!stack.isEmpty()) {
            int n = stack.pop();
            if(n + 1 != next)
                consecutive = false;
            next = n;
            queue.add(n);
        }
        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        return consecutive;
    }
    public boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = queue.size();
        boolean palindromeTest = true;
        for(int i = 0; i < size; i++) {
            int n = queue.remove();
            queue.add(n);
            stack.push(n);
        }
        for(int i = 0; i < size; i++) {
            int n1 = queue.remove();
            int n2 = stack.pop();

            if(n1 != n2){
                palindromeTest = false;
            }
            queue.add(n1);
        }
        return palindromeTest;
    }
    public boolean isSorted(Stack<Integer> stack) {
        if(stack.size() < 2) {
            return true;
        }
        Stack<Integer> sortStack = new Stack<Integer>();
        boolean sorted = true;
        int top = stack.pop();
        sortStack.push(top);
        while(!stack.isEmpty()) {
            int n = stack.pop();
            if(n < top) {
                sorted = false;
            }
            top = n;
            sortStack.push(top);
        }
        while(!sortStack.isEmpty()) {
            stack.push(sortStack.pop());
        }
        return sorted;
    }
    public static void mirror(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<Integer>();
        if (stack == null) {
            throw new IllegalArgumentException();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            int num = queue.remove();
            queue.add(num);
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < queueSize; i++) {
            queue.add(queue.remove());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }
}
