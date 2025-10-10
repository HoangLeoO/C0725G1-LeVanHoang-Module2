package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(getName() + " => RUNNABLE");

            // Chuyển sang TIMED_WAITING
            System.out.println(getName() + " => Sleeping for 2s (TIMED_WAITING)");
            Thread.sleep(2000);

            synchronized (MyThread.class) {
                System.out.println(getName() + " => Got lock (RUNNING)");
                Thread.sleep(10000); // Giữ lock lâu để t2 bị BLOCKED
                System.out.println(getName() + " => Releasing lock and waiting (WAITING)");
                MyThread.class.wait();    // Chuyển sang WAITING
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " => Finished (TERMINATED)");
    }
}
