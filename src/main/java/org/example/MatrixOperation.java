package org.example;

import java.util.concurrent.*;

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

        MatrixThreads matrixThreads = new MatrixThreads();
        Matrix matrixC = new Matrix();
        int[][] C = new int[matrixA.getMatrix().length][matrixB.getMatrix()[0].length];

        for(int i=0; i < matrixA.getMatrix().length; i++){
            int i_final = i;
            for(int k = 0; k < matrixB.getMatrix()[0].length; k++){
                int k_final = k;
                Thread thread = new Thread(){
                    public void run(){
                        int matrixElement = 0;
                        for(int j=0; j < matrixB.getMatrix().length; j++){
                            matrixElement += matrixA.getMatrix()[i_final][j] * matrixB.getMatrix()[j][k_final];
                        }
                        C[i_final][k_final] = matrixElement;
                    }
                };
                matrixThreads.startThread(i%10,thread);
            }

        }
        matrixThreads.joinThreads();
        matrixC.setMatrix(C);
        return matrixC;
    }


}
