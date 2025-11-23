package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedThreads {
    private Thread[] threads;
    private Queue<Runnable> queue = new LinkedList<>();
    private volatile boolean running = true;

    public FixedThreads(int threadsNo) {
        threads = new Thread[threadsNo];

        for (int i = 0; i < threadsNo; i++) {
            threads[i] = new Thread(() -> {
                while (running || !queue.isEmpty()) {
                    Runnable task;

                    synchronized (queue) {
                        while (queue.isEmpty() && running) {
                            try {
                                queue.wait();
                            } catch (InterruptedException ignored) {}
                        }

                        if (!running && queue.isEmpty())
                            return;

                        task = queue.poll();
                    }

                    task.run();
                }
            });

            threads[i].start();
        }
    }

    public void addTask(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }
    }

    public void shutdown() {
        synchronized (queue) {
            running = false;
            queue.notifyAll();
        }
    }

    public void joinThreads(){
        for(Thread thread : threads){
            if(thread != null){
                try{
                    thread.join();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
