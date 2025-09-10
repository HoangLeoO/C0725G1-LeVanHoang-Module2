package ss4_oop.bai_tap.bai_tap2;

import java.time.LocalDateTime;
import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }
    public void start(){
         this.startTime = System.currentTimeMillis();
        System.out.println(this.startTime);
    }
    public void stop(){
         this.endTime = System.currentTimeMillis();
        System.out.println(this.endTime);
    }
    public long getElapsedTime(){
        return this.endTime - startTime;
    }

}
