package service;

import java.util.Date;
import java.util.Map;
import java.util.Queue;
public class Timmer_Poll {
    private Queue<Map<Date,Runnable>> runnableQueue;

    public Timmer_Poll(Queue<Map<Date, Runnable>> runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    public void addRunnable(Date timeStart, Runnable runnable){

    }
    public void removeRunnable(Runnable runnable){

    }

}
