package org.example;

public class MultiplyTask implements Runnable{
    private Matrix matrixA;
    private Matrix matrixB;
    private int rowNo;
    private int columnNo;
    private int matrixElement;
    int[][] result;

    MultiplyTask(Matrix matrixA, Matrix matrixB, int i, int k, int[][] result){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rowNo = i;
        this.columnNo = k;
        this.result = result;
    }

    @Override
    public void run(){
        matrixElement = 0;
        for(int j=0; j < matrixB.getMatrix().length; j++){
            matrixElement += matrixA.getMatrix()[rowNo][j] * matrixB.getMatrix()[j][columnNo];
        }
        result[rowNo][columnNo] = matrixElement;
    }

}
