package org.example;

import java.util.Arrays;

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
        // int[][] C = new int[this.getRowsNo()][matrixB.getColumnsNo()];
        int[][] C = new int[matrixC.rowsNo][matrixC.columnsNo];
        int matrixElement;
        for(int i=0; i < this.getRowsNo(); i++){
            for(int k=0; k<matrixB.getColumnsNo(); k++){
                matrixElement = 0;
                for(int j=0; j < matrixB.getRowsNo(); j++){
                    matrixElement += A[i][j] * B[j][k];
                }
                C[i][k] = matrixElement;
            }
        }
        matrixC.setMatrix(C);

        return matrixC;
    }

    public synchronized void print(){
        for(int i=0; i < rowsNo; i++){
            for(int j=0; j < columnsNo; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.print("\n");
        }
    }
}

