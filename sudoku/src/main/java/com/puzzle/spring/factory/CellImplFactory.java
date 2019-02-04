package com.puzzle.spring.factory;

import com.puzzle.spring.structure.CellImpl;
import com.puzzle.spring.structure.Column;
import com.puzzle.spring.structure.Row;

public class CellImplFactory {
	
	public static <T> CellImpl<T> createCell(){
		return new CellImpl<T>();
	}
	
	public static <T> CellImpl<T> createCell(Row<T> row,Column<T> column){
		return new CellImpl<T>(row,column);
	}
	
}
