package com.puzzle.spring.factory;

import java.util.Collection;

import com.puzzle.spring.structure.RowImpl;

public class RowImplFactory {
	
	public static <T> RowImpl<T> createRow() {
		return new RowImpl<T>();
	}
	
	public static <T> RowImpl<T> createRow(Collection<T> collection) {
		return new RowImpl<T>(collection);
	}
	
	public static <T> RowImpl<T> createRow(Collection<T> collection,T result) {
		return new RowImpl<T>(collection,result);
	}
}
