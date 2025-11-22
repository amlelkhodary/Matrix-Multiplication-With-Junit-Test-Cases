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
            try{
                threads[threadNo].join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        finally{
            locks[threadNo].unlock();
        }
    }
}
