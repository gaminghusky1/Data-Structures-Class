import java.util.*;

public class StackQueuePractice {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(21) - 10);
        }

        // Stack<Integer> stack2 = new Stack<>();
//       for(int i = 0; i < 10; i++){
//          stack2.push(random.nextInt(21)-10);
//       }


        Stack<Integer> stack2 = (Stack) stack.clone();
        System.out.println(stack);
        System.out.println(stack2);
        System.out.println(equals(stack, stack2));
        //splitStack(stack);
        //stutter(stack);
        System.out.println(stack);
        Queue<Integer> queue = new LinkedList<>();

        int maxInt = Integer.MIN_VALUE;
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
            maxInt = Math.max(maxInt, temp.peek());
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println(maxInt);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>();

        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty()) {
            temp.push(s1.pop());
            temp.push(s2.pop());
        }

        int size = temp.size();
        boolean isSame = true;
        for (int i = 0; i < size / 2; i++) {
            s2.push(temp.pop());
            s1.push(temp.pop());
            if (s1.peek() != s2.peek()) {
                isSame = false;
            }
        }

        return isSame;

    }

    public boolean equals2(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> s3 = new Stack<Integer>();
        boolean same = true;
        if (s1.size() != s2.size()) {
            return false;
        } else {
            while (!s1.isEmpty() && s1.peek() == s2.peek()) {
                s1.pop();
                s3.push(s2.pop());
            }
            if (!s1.isEmpty()) {
                same = false;
            }
            while (!s3.isEmpty()) {
                int putItBack = s3.pop();
                s1.push(putItBack);
                s2.push(putItBack);
            }
        }
        return same;
    }


    public static void stutter(Stack<Integer> s) {

    }

    public static void splitStack(Stack<Integer> s) {

    }

    public static void reverseStack(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
    }
}