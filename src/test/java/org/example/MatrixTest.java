package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void whenMatrixAColumnsNotEqualMatrixBRowsShouldReturnIllegalArguementException(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA_thread1 = new Matrix(2,3);
            Matrix matrixB_thread1 = new Matrix(2,2);
            assertThrows(IllegalArgumentException.class, () -> {
                Matrix matrixC_thread1 = matrixA_thread1.multiply(matrixB_thread1);
            });
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA_thread2 = new Matrix(4,5);
            Matrix matrixB_thread2 = new Matrix(3,2);
            assertThrows(IllegalArgumentException.class, () -> {
                Matrix matrixC_thread2 = matrixA_thread2.multiply(matrixB_thread2);
            });
        });
        thread1.start();
        thread2.start();
    }

    @Test
    void whenArraysNotInitializedShouldReturnNullPointerException(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA = new Matrix();
            Matrix matrixB = new Matrix();
            assertThrows(NullPointerException.class, () ->{
                matrixA.multiply(matrixB);
            });
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA = new Matrix();
            Matrix matrixB = new Matrix();
            assertThrows(NullPointerException.class, () ->{
                matrixA.multiply(matrixB);
            });
        });
        thread1.start();
        thread2.start();
    }

    @Test
    void multipliedMatrixRowsNoShouldEqualFirstMatrixRowsNo(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA = new Matrix(2,3);
            Matrix matrixB = new Matrix(3,2);
            Matrix matrixC = matrixA.multiply(matrixB);
            assertEquals(2, matrixC.getRowsNo());
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA = new Matrix(5,3);
            Matrix matrixB = new Matrix(3,6);
            Matrix matrixC = matrixA.multiply(matrixB);
            assertEquals(5, matrixC.getRowsNo());
        });
        thread1.start();
        thread2.start();
    }

    @Test
    void multipliedMatrixColumnsNoShouldEqualSecondMatrixColumnsNo(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA = new Matrix(2,3);
            Matrix matrixB = new Matrix(3,10);
            Matrix matrixC = matrixA.multiply(matrixB);
            assertEquals(10, matrixC.getColumnsNo());
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA = new Matrix(3,5);
            Matrix matrixB = new Matrix(5,15);
            Matrix matrixC = matrixA.multiply(matrixB);
            assertEquals(15, matrixC.getColumnsNo());
        });
        thread1.start();
        thread2.start();
    }

    @Test
    void checkThatMultiplyIsCorrectTest1(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA = new Matrix(4,5);
            matrixA.setMatrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}});
            Matrix matrixB = new Matrix(5,3);
            matrixB.setMatrix(new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
            int[][] multiply = {{135, 150, 165},{310, 350, 390},{485, 550, 615},{660, 750, 840}};
            assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
            Matrix matrixB = new Matrix(3,2, new int[][]{{1,2},{2,3},{3,4}});
            int[][] multiply = {{14,20},{32,47}};
            assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
        });
        thread1.start();
        thread2.start();
    }
    @Test
    void checkThatMultiplyIsCorrectTest2(){
        Thread thread1 = new Thread(() -> {
            Matrix matrixA = new Matrix(8,2);
            matrixA.setMatrix(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}, {13, 14}, {15, 16}});
            Matrix matrixB = new Matrix(2,6);
            matrixB.setMatrix(new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12}});
            int[][] multiply = {{15, 18, 21, 24, 27, 30},{31, 38, 45, 52, 59, 66},{47,58,69,80,91,102},{63,78,93,108,123,138},{79,98,117,136,155,174},{95,118,141,164,187,210},{111,138,165,192,219,246},{127,158,189,220,251,282}};
            assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
        });

        Thread thread2 = new Thread(() -> {
            Matrix matrixA = new Matrix(4,2, new int[][]{{1,2},{3,4},{5,6},{7,8}});
            Matrix matrixB = new Matrix(2,3, new int[][]{{1,2,3},{4,5,6}});
            int[][] multiply = {{9,12,15},{19,26,33},{29,40,51},{39,54,69}};
            assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
        });
        thread1.start();
        thread2.start();
    }
}