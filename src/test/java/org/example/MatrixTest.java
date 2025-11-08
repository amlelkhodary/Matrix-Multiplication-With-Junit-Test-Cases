package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void whenMatrixAColumnsNotEqualMatrixBRowsShouldReturnIllegalArguementException(){
        Matrix matrixA = new Matrix(2,3);
        Matrix matrixB = new Matrix(2,2);
        assertThrows(IllegalArgumentException.class, () -> {
            Matrix matrixC = matrixA.multiply(matrixB);
        });
    }

    @Test
    void whenArraysNotInitializedShouldReturnNullPointerException(){
        Matrix matrixA = new Matrix();
        Matrix matrixB = new Matrix();
        assertThrows(NullPointerException.class, () ->{
            matrixA.multiply(matrixB);
        });
    }

    @Test
    void multipliedMatrixRowsNoShouldEqualFirstMatrixRowsNo(){
        Matrix matrixA = new Matrix(2,3);
        Matrix matrixB = new Matrix(3,2);
        Matrix matrixC = matrixA.multiply(matrixB);
        assertEquals(2, matrixC.getRowsNo());
    }

    @Test
    void multipliedMatrixColumnsNoShouldEqualSecondMatrixColumnsNo(){
        Matrix matrixA = new Matrix(2,3);
        Matrix matrixB = new Matrix(3,10);
        Matrix matrixC = matrixA.multiply(matrixB);
        assertEquals(10, matrixC.getColumnsNo());
    }

    @Test
    void checkThatMultiplyIsCorrectTest1(){
        Matrix matrixA = new Matrix(4,5);
        matrixA.setMatrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}});
        Matrix matrixB = new Matrix(5,3);
        matrixB.setMatrix(new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}});
//        assertEquals(new int[][]{{135, 150, 165},{310, 350, 390},{485, 550, 615},{660, 750, 840}}, matrixA.multiply(matrixB).getMatrix());
        int[][] multiply = {{135, 150, 165},{310, 350, 390},{485, 550, 615},{660, 750, 840}};
        assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
    }

    @Test
    void checkThatMultiplyIsCorrectTest2(){
        Matrix matrixA = new Matrix(8,2);
        matrixA.setMatrix(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}, {13, 14}, {15, 16}});
        Matrix matrixB = new Matrix(2,6);
        matrixB.setMatrix(new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12}});
        int[][] multiply = {{15, 18, 21, 24, 27, 30},{31, 38, 45, 52, 59, 66},{47,58,69,80,91,102},{63,78,93,108,123,138},{79,98,117,136,155,174},{95,118,141,164,187,210},{111,138,165,192,219,246},{127,158,189,220,251,282}};
        assertTrue(Arrays.deepEquals(multiply, matrixA.multiply(matrixB).getMatrix()));
    }
}