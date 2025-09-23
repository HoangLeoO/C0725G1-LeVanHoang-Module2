package ss11_stack_queue.bai_tap.bai_tap_op_2;

import java.util.*;

public class StackQueue {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        Stack<Character> stringStack = new Stack<>();
        Queue<Character> stringQueue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stringQueue.add(c);
            stringStack.push(c);
        }
        boolean check = true;
        while (!stringStack.isEmpty()) {
            if (Objects.equals(stringQueue.poll(), stringStack.pop())) {
                check = false;
                break;
            }
        }
        System.out.println(check ? "Yes" : "No");
    }
}
