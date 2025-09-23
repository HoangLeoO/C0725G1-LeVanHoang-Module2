package ss11_stack_queue.bai_tap.bai_tap_op_1;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> numStack = new Stack<>();
        int n = 30;
        int q;
        int d;
        do {
            q = n / 2;
            d = n % 2;
            n = q ;
            numStack.push(d);
        }
        while (q != 0);
        System.out.println(numStack);
        String isNum = "";
        while (!numStack.isEmpty()){
            isNum += numStack.pop();
        }
        System.out.println(isNum);
    }
}
