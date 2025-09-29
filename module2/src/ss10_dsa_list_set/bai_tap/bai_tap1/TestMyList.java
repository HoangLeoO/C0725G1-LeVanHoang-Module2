package ss10_dsa_list_set.bai_tap.bai_tap1;

public class TestMyList {
    public static void main(String[] args) throws ListException {
        MyList<String> myList = new MyList<>();
        myList.add("Hoang");
        myList.clone();
        System.out.println(myList.get(0));
    }
}

