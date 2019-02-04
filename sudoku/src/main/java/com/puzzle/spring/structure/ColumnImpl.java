package com.puzzle.spring.structure;

import java.util.Collection;

public class ColumnImpl<T> implements Column<T>{

	private T result;
	private Collection<T> collection;
	Integer columnSize = 0;
	
	public Integer getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}

	public ColumnImpl() {
		
	}
	
	public ColumnImpl(Collection<T> collection){
		this();
		this.collection = collection;
	}
	
	public ColumnImpl(Collection<T> collection,T result){
		this(collection);
		this.result = result;
	}
	
	public boolean isEmpty() {
		return collection.size() != columnSize;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	public boolean setValue(T value) {
		return collection.add(value);
	}

	public T delete(T value) {
		T tempValue = null;
		if (collection.remove(value)) {
			tempValue = value;
		}
		return tempValue;
	}
	
}
