package ss11_stack_queue.bai_tap.bai_tap1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
       Stack<Integer> listNumber = new Stack<>();
       for (int i = 0 ; i < arr.length ; i++){
           listNumber.push(arr[i]);
       }
       for (Integer num : listNumber){
           System.out.println(num);
       }
       int[] arr2 = new int[arr.length];
        for (int i = 0 ; i < arr2.length ; i++){
            arr2[i] = listNumber.pop();
        }
        System.out.println("arr2 "  + Arrays.toString(arr2));
        String str = "Hoang dep trai";
        String[] newMWord = str.trim().split("\\s+");
        Stack<String> strStack = new Stack<>();
        for (int i = 0 ; i < newMWord.length;i++){
            strStack.push(newMWord[i]);
        }
        String newStr = "" ;
        while (!strStack.isEmpty()){
            newStr+= strStack.pop() + " ";
        }

        System.out.println(newStr);
    }
}
