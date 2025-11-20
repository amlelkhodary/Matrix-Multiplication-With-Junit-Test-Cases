package org.example;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    protected int[][] matrix;

    Matrix(){
    }

    Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }
    public int[][] getMatrix(){
        return matrix;
    }

    public void print(){
        ReentrantLock mutex = new ReentrantLock();
        try{
            mutex.lock();
            for(int i=0; i < matrix.length; i++){
                for(int j=0; j < matrix[0].length; j++){
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

