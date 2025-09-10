package ss4_oop.bai_tap.bai_tap2;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (long i = 0 ; i < 10000; i++){
            System.out.println(i);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}
