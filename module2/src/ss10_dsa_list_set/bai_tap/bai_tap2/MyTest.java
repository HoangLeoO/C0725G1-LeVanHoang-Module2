package ss10_dsa_list_set.bai_tap.bai_tap2;

public class MyTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("S");
        myLinkedList.add("E");
        myLinkedList.add("D");
        myLinkedList.addLast("H");
        for (int i = 0 ; i < myLinkedList.size() ; i++){
            System.out.println(myLinkedList.get(i));
        }
        myLinkedList.add(2,"O");
        System.out.println("--------------");
        for (int i = 0 ; i < myLinkedList.size() ; i++){
            System.out.println(myLinkedList.get(i));
        }
    }
}
