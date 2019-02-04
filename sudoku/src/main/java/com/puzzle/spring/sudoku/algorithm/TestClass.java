package com.puzzle.spring.sudoku.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.puzzle.spring.structure.CellImpl;
import com.puzzle.spring.structure.DataSetImpl;
import com.puzzle.spring.structure.TableImpl;

public class TestClass {
	
	int[] rowResultSet;
	int[] columnResultSet;
	int matrixLength;
	
	public TestClass(){
		
	}
	
	public TestClass(int matrixLength){
		
	}
	
	public static void main(String[] args) {
		SudokuAlgorithm sudokuAlgorithm = new SudokuAlgorithm();
		int length = 4;
		TestClass test1 = new TestClass(length);
		int[][] testMatrix = test1.createRandomMatrix(length);
		test1.printArray(testMatrix);
		System.out.println("rowResultSet > " + Arrays.toString(test1.rowResultSet));
		System.out.println("columnResultSet " + Arrays.toString(test1.columnResultSet));
		DataSetImpl<Integer> dataSet = new DataSetImpl<Integer>(new LinkedList<Integer>());
		TableImpl<Integer> tableImpl = new TableImpl<Integer>(length, length, new LinkedList<Integer>());
		int[] rowResultSet = test1.rowResultSet;
		int[] columnResultSet = test1.columnResultSet;
		sudokuAlgorithm.createDataSet(dataSet,length * length);
		sudokuAlgorithm.initialize(tableImpl.getCells(),rowResultSet,columnResultSet);
		LinkedList<CellImpl<Integer>> cellList = (LinkedList<CellImpl<Integer>>)sudokuAlgorithm.getList(tableImpl.getCells());
		
		//calling solution
		sudokuAlgorithm.solution(tableImpl, dataSet, cellList);
		if (test1.testMatrix(test1.getIntegerMatrix(tableImpl.getCells()), testMatrix));
			System.out.println("succesfull");
		sudokuAlgorithm.print(tableImpl.getCells());
		
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
	
	public void printArray(int[][] array) {
		for(int i = 0 ; i < array.length ; i++) {
			String str = "";
			for(int j = 0 ; j < array[i].length ; j++) {
				System.out.print(str + array[i][j]);
				str = ",";
			}
			System.out.println();
		}
	}
	
	public boolean testMatrix(int[][] testArray1, int[][] testArray2) {
		for(int i = 0 ; i < testArray1.length ; i++) {
			for(int j = 0 ; j < testArray2.length ; j++) {
				if (testArray1[i][j] != testArray2[i][j])
					return false;
			}
		}
		return true;
	}
	
	public int[][] getIntegerMatrix(CellImpl<Integer>[][] cells){
		int[][] matrix = new int[cells.length][cells.length];
		int i = 0, j = 0;
		for(CellImpl<Integer>[] cels : cells) {
			j = 0;
			for(CellImpl<Integer> cell : cels) {
				matrix[i][j++] = cell.getValue();
			}
			i++;
			
		}
		return matrix;
	}
	
}
