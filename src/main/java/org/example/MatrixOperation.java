package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixOperation {
    Matrix matrixA;
    Matrix matrixB;
    public MatrixOperation(Matrix matrixA, Matrix matrixB){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public Matrix multiply(){
        if(matrixA.getMatrix()[0].length != matrixB.getMatrix().length)
            throw new IllegalArgumentException("Columns No in matrix A must equal Rows No in matrix B");
        if((matrixA.getMatrix() == null) || (matrixB.getMatrix() == null))
            throw new NullPointerException("Matrix is not initialized yet");

        Matrix matrixC = new Matrix();
        int[][] C = new int[matrixA.getMatrix().length][matrixB.getMatrix()[0].length];
        Thread[] threads = new Thread[matrixA.getMatrix().length];

        for(int i=0; i < matrixA.getMatrix().length; i++){
            int i_final = i;
            threads[i] = new Thread(){
                public void run(){
                    for(int k = 0; k < matrixB.getMatrix()[0].length; k++){
                        int matrixElement = 0;
                        for(int j=0; j < matrixB.getMatrix().length; j++){
                            matrixElement += matrixA.getMatrix()[i_final][j] * matrixB.getMatrix()[j][k];
                        }
                        C[i_final][k] = matrixElement;
                    }
                }
            };
            threads[i].start();
        }

        for(Thread thread : threads){
            try{
                thread.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        matrixC.setMatrix(C);
        return matrixC;
    }
}
