package ss4_oop.bai_tap.bai_tap2;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] arrayNumber = new int[100000];
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = (int) (Math.random() * 100000);
        }
        for (int i = 0; i < arrayNumber.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arrayNumber.length; j++) {
                if (arrayNumber[j] < arrayNumber[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arrayNumber[i];
            arrayNumber[i] = arrayNumber[minIndex];
            arrayNumber[minIndex] = temp;
        }
        stopWatch.stop();
        System.out.println(arrayNumber[0]);
        System.out.println(arrayNumber[arrayNumber.length - 1]);
        System.out.println(stopWatch.getElapsedTime());
    }
}
