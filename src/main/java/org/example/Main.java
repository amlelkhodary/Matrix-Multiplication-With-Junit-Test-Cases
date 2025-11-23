package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        FixedThreads fixedThreads = new FixedThreads(10);
        Matrix A = new Matrix();
        Matrix B = new Matrix();
        A.setMatrix(new int[][] {{1,2,3},{4,5,6}});
        B.setMatrix(new int[][]{{1},{2},{3}});
        MatrixOperation operation = new MatrixOperation(A, B, fixedThreads);
        Matrix C = operation.multiply();
        fixedThreads.shutdown();
        fixedThreads.joinThreads();
        C.print();
    }
}