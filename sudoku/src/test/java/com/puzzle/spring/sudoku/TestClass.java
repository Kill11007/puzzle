package com.puzzle.spring.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.puzzle.spring.structure.CellImpl;

public class TestClass {
	
	int[] rowResultSet;
	int[] columnResultSet;
	int matrixLength;
	
	public TestClass(){
		
	}
	
	public TestClass(int matrixLength){
		
	}
	
	public static void main(String[] args) {
		TestClass test1 = new TestClass();
		int matrixLength = 5;
		test1.printArray(test1.createRandomMatrix(matrixLength));
		
		System.out.println(Arrays.toString(test1.rowResultSet));
		System.out.println(Arrays.toString(test1.columnResultSet));
	}
	
	public int[][] createRandomMatrix(int matrixLength){
		int[] dataSet = createDataSet(matrixLength * matrixLength);
		Random rn = new Random();
		int nextInt = 0;
		List<Integer> dataList = new ArrayList<Integer>();
		for(int i : dataSet) {
			dataList.add(i);
		}
		int[][] matrix = new int[matrixLength][matrixLength];
		rowResultSet = new int[matrixLength];
		columnResultSet = new int[matrixLength];
		for (int i = 0 ; i < matrixLength ; i++) {
			for(int j = 0; j < matrixLength ; j++) {
				//System.out.println("dataList size : " + dataList.size());
				nextInt = rn.nextInt(dataList.size());
				//System.out.println("nextInt : " + nextInt);
				matrix[i][j] = dataList.get(nextInt);
				rowResultSet[i] += matrix[i][j];
				dataList.remove(nextInt);
				columnResultSet[j] += matrix[i][j];
			}
			
		}
		return matrix;
	}
	
	public int[] createDataSet(int length) {
		int[] dataSet = new int[length];
		for(int i = 0; i < dataSet.length ; i++) {
			dataSet[i] = i+1;
		}
		return dataSet;
	}
	
	private void printArray(int[][] array) {
		for(int i = 0 ; i < array.length ; i++) {
			String str = "";
			for(int j = 0 ; j < array[i].length ; j++) {
				System.out.print(str + array[i][j]);
				str = ", ";
			}
			System.out.println();
		}
	}
	
	
	
}
