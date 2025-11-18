package org.example;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    protected int rowsNo;
    protected int columnsNo;
    protected int[][] matrix;

    Matrix(){
//        matrix = new int[rowsNo][columnsNo];
    }
    Matrix(int rowsNo, int columnsNo){
        this.rowsNo = rowsNo;
        this.columnsNo = columnsNo;
        matrix = new int[rowsNo][columnsNo];
    }
    Matrix(int rowsNo, int columnsNo, int[][] matrix){
        this.rowsNo = rowsNo;
        this.columnsNo = columnsNo;
        this.matrix = matrix;
    }
    public void setRowsNo(int rowsNo){
        this.rowsNo = rowsNo;
    }
    public int getRowsNo(){
        return rowsNo;
    }
    public void setColumnsNo(int columnsNo){
        this.columnsNo = columnsNo;
    }
    public int getColumnsNo(){
        return columnsNo;
    }
    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }
    public int[][] getMatrix(){
        return matrix;
    }

    public Matrix multiply(Matrix matrixB){
        if(this.getColumnsNo() != matrixB.getRowsNo())
            throw new IllegalArgumentException("Columns No in matrix A must equal Rows No in matrix B");
        if((matrix == null) || (matrixB.getMatrix() == null))
            throw new NullPointerException("Matrix is not initialized yet");

        Matrix matrixC = new Matrix(this.getRowsNo(), matrixB.getColumnsNo());
        int[][] A = this.getMatrix();
        int[][] B = matrixB.getMatrix();
        int[][] C = new int[matrixC.rowsNo][matrixC.columnsNo];

        ExecutorService rowsThreads = Executors.newFixedThreadPool(matrixC.rowsNo);
        for(int i=0; i < this.getRowsNo(); i++){
            final int i_final = i;
            rowsThreads.submit(()->{
                for(int k = 0; k < matrixB.getColumnsNo(); k++){
                    int matrixElement = 0;
                    for(int j=0; j < matrixB.getRowsNo(); j++){
                        matrixElement += A[i_final][j] * B[j][k];
                    }
                    C[i_final][k] = matrixElement;
                }
            });
        }
        rowsThreads.shutdown();
        try {
            rowsThreads.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        matrixC.setMatrix(C);
        return matrixC;
    }

    public void print(){
        ReentrantLock mutex = new ReentrantLock();
        try{
            mutex.lock();
            for(int i=0; i < rowsNo; i++){
                for(int j=0; j < columnsNo; j++){
                    System.out.print(matrix[i][j] +" ");
                }
                System.out.print("\n");
            }
        }
        finally{
            mutex.unlock();
        }

    }
}

