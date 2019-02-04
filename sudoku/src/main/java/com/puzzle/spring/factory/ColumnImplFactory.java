package com.puzzle.spring.factory;

import java.util.Collection;

import com.puzzle.spring.structure.ColumnImpl;

public class ColumnImplFactory {
	
	public static <T> ColumnImpl<T> createColumn() {
		return new ColumnImpl<T>();
	}
	
	public static <T> ColumnImpl<T> createColumn(Collection<T> collection) {
		return new ColumnImpl<T>(collection);
	}
	
	public static <T> ColumnImpl<T> createColumn(Collection<T> collection,T result) {
		return new ColumnImpl<T>(collection,result);
	}
	
}
