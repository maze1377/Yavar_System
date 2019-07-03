package service;


import Model.Date;

import java.util.Map;
import java.util.Queue;

public class TimerPoll {
    private Queue<Map<Date, Runnable>> runnableQueue;

    public TimerPoll(Queue<Map<Date, Runnable>> runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    public void addRunnable(Date timeStart, Runnable runnable) {

    }
}
