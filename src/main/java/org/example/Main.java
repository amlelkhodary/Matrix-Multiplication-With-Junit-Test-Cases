package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix(2,3);
        // int[][] arrayA = {{1,2,3},{4,5,6}};
        // A.setMatrix(arrayA);
        A.setMatrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix B = new Matrix(3,1);
        B.setMatrix(new int[][]{{1},{2},{3}});

        Matrix C = new Matrix();
        C = A.multiply(B);
//        C.multiplyMatrices(A,B);

        C.print();
        System.out.println("************************************");
        A.setRowsNo(4);
        A.setColumnsNo(5);
        A.setMatrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}});
        B.setRowsNo(5);
        B.setColumnsNo(3);
        B.setMatrix(new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
        C = A.multiply(B);
//        C.multiplyMatrices(A,B);
        C.print();
        System.out.println("************************************");

//        A.setRowsNo(1);
//        A.setColumnsNo(2);
//        A.setMatrix(new int[][]{{1,2}});
//        B.setRowsNo(1);
//        B.setColumnsNo(2);
//        B.setMatrix(new int[][]{{1,2}});
//        C = A.multiply(B); // expected to see IllegalArgumentException
//
//
//        Matrix one =  new Matrix(2,2);
//        Matrix two = new Matrix(2,1);
//        Matrix three = one.multiply(two);
//        three.print(); // Expected to see zeros

        Matrix matrixThread1_1 = new Matrix(4,2, new int[][]{{1,2},{3,4},{5,6},{7,8}});
        Matrix matrixThread1_2 = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
        Matrix matrixThread1 = matrixThread1_1.multiply(matrixThread1_2);
        matrixThread1.print();
        System.out.println("************************************");


        Matrix matrixThread2_1 = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
        Matrix matrixThread2_2 = new Matrix(3,2, new int[][]{{1,2},{2,3},{3,4}});
        Matrix matrixThread2 = matrixThread2_1.multiply(matrixThread2_2);
        matrixThread2.print();
        System.out.println("------------------------------------");


//        ExecutorService threads = Executors.newFixedThreadPool(2);
//        threads.submit(() -> {
//            Matrix matrixThread1_1 = new Matrix(4,2, new int[][]{{1,2},{3,4},{5,6},{7,8}});
//            Matrix matrixThread1_2 = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
//            Matrix matrixThread1 = matrixThread1_1.multiply(matrixThread1_2);
//            matrixThread1.print();
//            System.out.println("************************************");
//        });
//
//        threads.submit(() -> {
//            Matrix matrixThread2_1 = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
//            Matrix matrixThread2_2 = new Matrix(3,2, new int[][]{{1,2},{2,3},{3,4}});
//            Matrix matrixThread2 = matrixThread2_1.multiply(matrixThread2_2);
//            matrixThread2.print();
//            System.out.println("------------------------------------");
//        });


//        threads.shutdown();
    }
}