package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        A.setMatrix(new int[][] {{1,2,3},{4,5,6}});
        Matrix B = new Matrix();
        B.setMatrix(new int[][]{{1},{2},{3}});
        MatrixOperation operation = new MatrixOperation(A,B);
        operation.multiply().print();
        System.out.println("************************************");

        A.setMatrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}});
        B.setMatrix(new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
        operation.multiply().print();
    }
}