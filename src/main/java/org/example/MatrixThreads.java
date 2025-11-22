package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThreads {

    private Thread[] threads = new Thread[10];
    private Lock[] locks = new ReentrantLock[10];

    public void startThread(int threadNo, Thread thread){
        try{
            locks[threadNo] = new ReentrantLock();
            locks[threadNo].lock();
            threads[threadNo] = thread;
            threads[threadNo].start();
        }
        finally{
            locks[threadNo].unlock();
        }
    }
    public void joinThreads(){
        for(int i=0; i<10; i++){
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
}
