package com.puzzle.spring.sudoku.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.puzzle.spring.structure.CellImpl;
import com.puzzle.spring.structure.Column;
import com.puzzle.spring.structure.ColumnImpl;
import com.puzzle.spring.structure.DataSetImpl;
import com.puzzle.spring.structure.ResultSetImpl;
import com.puzzle.spring.structure.Row;
import com.puzzle.spring.structure.RowImpl;
import com.puzzle.spring.structure.TableImpl;

public class SudokuAlgorithm {
	
	public void solution(TableImpl<Integer> tableImpl,DataSetImpl<Integer> dataSetImpl,LinkedList<CellImpl<Integer>> cellList) {
		RowImpl<Integer> row = null;
		ColumnImpl<Integer> column = null;
		CellImpl<Integer> cell = null;
		Integer value = null;
		Integer index = 0;
		while(tableImpl.isEmpty()) {
			cell = cellList.get(index++);
			value = dataSetImpl.get();
			cell.put(value);
			dataSetImpl.delete(value);
			row = (RowImpl<Integer>)cell.getRow();
			column = (ColumnImpl<Integer>)cell.getColumn();
			if (!row.isEmpty()) {
				if ( sum(row) != row.getResult()) {
					index = recurse(cellList, cell, dataSetImpl, index); //try boolean return
				}
			}
			if (!column.isEmpty()) {
				if ( sum(column) != column.getResult()) {
					index = recurse(cellList, cell, dataSetImpl, index);
				}
			}
		}
	}
	
	public Integer recurse(LinkedList<CellImpl<Integer>> cellList,CellImpl<Integer> cell,DataSetImpl<Integer> dataSetImpl,Integer index) {
		index--;
		while (cell.getPutCount() == (cellList.size() - index) && index >= 0) {
			Integer val = cell.getValue();
			cell.delete();
			dataSetImpl.add(val);
			cell.setPutCount(0);
			cell = cellList.get(--index);
		}
		dataSetImpl.add(cell.getValue());
		cell.delete();
		return index;
	}
	
	public int sum(Row<Integer> row) {
		RowImpl<Integer> rowImpl = (RowImpl<Integer>)row;
		LinkedList<Integer> rlist = (LinkedList<Integer>)(rowImpl.getCollection());
		int sum = 0;
		for(Integer i : rlist)
			sum = sum + i;
		return sum;
	}
	

	public int sum(Column<Integer> Column) {
		ColumnImpl<Integer> ColumnImpl = (ColumnImpl<Integer>)Column;
		LinkedList<Integer> rlist = (LinkedList<Integer>)(ColumnImpl.getCollection());
		int sum = 0;
		for(Integer i : rlist)
			sum = sum + i;
		return sum;
	}
	
	public List<CellImpl<Integer>> getList(CellImpl<Integer>[][] cells){
		LinkedList<CellImpl<Integer>> cellList = new LinkedList<CellImpl<Integer>>();
		for(CellImpl<Integer>[] cels: cells) {
			for(CellImpl<Integer> cell: cels) {
				cellList.add(cell);
			}
		}
		return cellList;
	}
	
	public void createDataSet(DataSetImpl<Integer> dataSet,int length) {
		for(int i = 1 ; i <= length ; i++) {
			dataSet.add(i);
		}
	}
	
	public void initialize(CellImpl<Integer>[][] cells, int[] rowResultSet, int[] columnResultSet) {
		
		rowAndColumnInitialize(cells,rowResultSet,columnResultSet);
		//addPutCount(cells);
		
	}
	
	public void rowAndColumnInitialize(CellImpl<Integer>[][] cells, int[] rowResultSet, int[] columnResultSet) {
		ResultSetImpl<Integer> resultSet = new ResultSetImpl<Integer>();
		Row<Integer> row = null;
		Column<Integer> column = null;
		
		for(int i = 0 ; i < rowResultSet.length ; i++) {
			resultSet.setResult(rowResultSet[i]);
			row = cells[i][0].getRow();
			row.setCollection(new LinkedList<Integer>());
			resultSet.add(resultSet.getResult(), row);
		}
		
		for(int i = 0 ; i < columnResultSet.length ; i++) {
			resultSet.setResult(columnResultSet[i]);
			column = cells[0][i].getColumn();
			column.setCollection(new LinkedList<Integer>());
			resultSet.add(resultSet.getResult(), column);
		}
		
	}
	
	public void print(CellImpl<Integer>[][] cells) {
		for(CellImpl<Integer>[] cels: cells) {
			String str = "";
			for(CellImpl<Integer> cell: cels) {
				System.out.print(str + cell.getValue());
				str = ",";
			}
			System.out.println();
		}
	}
	
}
