package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedThreads {
    private int threadsNo;
    private Thread[] threads;
    private Lock[] locks;

    FixedThreads(int threadsNo){
        this.threadsNo = threadsNo;
        threads = new Thread[threadsNo];
        locks = new ReentrantLock[threadsNo];
    }

    public void addTask(int threadIndex, Runnable task){
        try{
            locks[threadIndex] = new ReentrantLock();
            locks[threadIndex].lock();
            threads[threadIndex] = new Thread(task);
            threads[threadIndex].start();
        }
        finally{
            locks[threadIndex].unlock();
        }
    }

    public void joinThreads(){
        for(int i=0; i<threadsNo; i++){
            if(threads[i] != null){
                try{
                    threads[i].join();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void setThreadNo(int threadNo){
        this.threadsNo = threadNo;
    }
    public int getThreadNo(){
        return threadsNo;
    }
}
