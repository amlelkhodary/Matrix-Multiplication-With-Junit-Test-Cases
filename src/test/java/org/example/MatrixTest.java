package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void whenMatrixAColumnsNotEqualMatrixBRowsShouldReturnIllegalArguementException(){
        Matrix matrixA = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix matrixB = new Matrix(new int[][]{{1,2},{3,4}});
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertThrows(IllegalArgumentException.class, () -> {
            operation.multiply();
        });
    }

    @Test
    void whenArraysNotInitializedShouldReturnNullPointerException(){
        Matrix matrixA = new Matrix();
        Matrix matrixB = new Matrix();
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertThrows(NullPointerException.class, () ->{
            operation.multiply();
        });
    }

    @Test
    void multipliedMatrixRowsNoShouldEqualFirstMatrixRowsNo(){
        Matrix matrixA = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix matrixB = new Matrix(new int[][]{{1,2},{3,4},{5,6}});
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertEquals(2, operation.multiply().getMatrix().length);
    }

    @Test
    void multipliedMatrixColumnsNoShouldEqualSecondMatrixColumnsNo(){
        Matrix matrixA = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix matrixB = new Matrix(new int[][]{{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10},{1,2,3,4,5,6,7,8,9,10}});
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertEquals(10, operation.multiply().getMatrix()[0].length);
    }

    @Test
    void checkThatMultiplyIsCorrectTest1(){
        Matrix matrixA = new Matrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}});
        Matrix matrixB = new Matrix(new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
        int[][] multiply = {{135, 150, 165},{310, 350, 390},{485, 550, 615},{660, 750, 840}};
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertTrue(Arrays.deepEquals(multiply, operation.multiply().getMatrix()));
    }

    @Test
    void checkThatMultiplyIsCorrectTest2(){
        Matrix matrixA = new Matrix(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}, {13, 14}, {15, 16}});
        Matrix matrixB = new Matrix(new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12}});
        int[][] multiply = {{15, 18, 21, 24, 27, 30},{31, 38, 45, 52, 59, 66},{47,58,69,80,91,102},{63,78,93,108,123,138},{79,98,117,136,155,174},{95,118,141,164,187,210},{111,138,165,192,219,246},{127,158,189,220,251,282}};
        MatrixOperation operation = new MatrixOperation(matrixA, matrixB);
        assertTrue(Arrays.deepEquals(multiply, operation.multiply().getMatrix()));
    }
}