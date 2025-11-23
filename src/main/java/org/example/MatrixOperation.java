package org.example;

import java.util.concurrent.*;

public class MatrixOperation {
    Matrix matrixA;
    Matrix matrixB;
    FixedThreads threads;

    public MatrixOperation(Matrix matrixA, Matrix matrixB, FixedThreads threads){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.threads = threads;
    }

    public Matrix multiply(){
        if(matrixA.getMatrix()[0].length != matrixB.getMatrix().length)
            throw new IllegalArgumentException("Columns No in matrix A must equal Rows No in matrix B");
        if((matrixA.getMatrix() == null) || (matrixB.getMatrix() == null))
            throw new NullPointerException("Matrix is not initialized yet");

        Matrix matrixC = new Matrix();
        int[][] C = new int[matrixA.getMatrix().length][matrixB.getMatrix()[0].length];

        for(int i=0; i < matrixA.getMatrix().length; i++){
            for(int k = 0; k < matrixB.getMatrix()[0].length; k++) {
                MultiplyTask runnable = new MultiplyTask(matrixA, matrixB, i, k, C);
                threads.addTask(i % threads.getThreadNo(), runnable);
            }
        }

        threads.joinThreads();
        matrixC.setMatrix(C);
        return matrixC;
    }
}
