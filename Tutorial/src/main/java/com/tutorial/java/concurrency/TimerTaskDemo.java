/*
Java java.util.Timer is a utility class that can be used to schedule a thread to be executed at certain time in future.
Java Timer class can be used to schedule a task to be run one-time or to be run at regular intervals.
Timer class is thread safe
Timer class uses java.util.TaskQueue to add tasks at given regular interval and at any time there can be only one thread running the TimerTask

*/

package com.tutorial.java.concurrency;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new TimerTaskDemo();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}