package thread;

public class ThreadStateDemo {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        System.out.println(t1.getName() + " => " + t1.getState()); // NEW
        System.out.println(t2.getName() + " => " + t2.getState()); // NEW

        t1.start();
        Thread.sleep(500);
        t2.start(); // t2 sẽ cố vào synchronized khi t1 đang giữ lock

        // Quan sát trạng thái sau 1s
        Thread.sleep(1000);
        System.out.println(t1.getName() + " => " + t1.getState()); // RUNNABLE hoặc TIMED_WAITING
        System.out.println(t2.getName() + " => " + t2.getState()); // BLOCKED (đang chờ lock)

        Thread.sleep(4000);
        synchronized (MyThread.class) {

            System.out.println(t1.getName() + " => " + t1.getState()); // WAITING
            System.out.println(t2.getName() + " => " + t2.getState()); // Có thể RUNNABLE hoặc BLOCKED

            MyThread.class.notify();
//            MyThread.class.notify();// Đánh thức t1
        }

        Thread.sleep(1000);
        System.out.println(t1.getName() + " => " + t1.getState()); // TERMINATED
        System.out.println(t2.getName() + " => " + t2.getState());
    }
}

