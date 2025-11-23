package org.example;

import java.util.concurrent.CountDownLatch;

public class MultiplyTask implements Runnable{
    private Matrix matrixA;
    private Matrix matrixB;
    private int rowNo;
    private int columnNo;
    private int matrixElement;
    int[][] result;
    CountDownLatch latch;

    MultiplyTask(Matrix matrixA, Matrix matrixB, int i, int k, int[][] result, CountDownLatch latch){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rowNo = i;
        this.columnNo = k;
        this.result = result;
        this.latch = latch;
    }

    @Override
    public void run(){
        matrixElement = 0;
        for(int j=0; j < matrixB.getMatrix().length; j++){
            matrixElement += matrixA.getMatrix()[rowNo][j] * matrixB.getMatrix()[j][columnNo];
        }
        result[rowNo][columnNo] = matrixElement;
        latch.countDown();
    }

}
