package com.puzzle.spring.structure;

import java.util.Collection;

public class RowImpl<T> implements Row<T>{
	
	private Collection<T> collection;
	private T result;
	private Integer rowSize = 0;
	
	public Integer getRowSize() {
		return rowSize;
	}

	public void setRowSize(Integer rowSize) {
		this.rowSize = rowSize;
	}

	public RowImpl() {
		
	}
	
	public RowImpl(Collection<T> collection){
		this();
		this.collection = collection;
	}
	
	public RowImpl(Collection<T> collection,T result){
		this(collection);
		this.result = result;
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

	public boolean isEmpty() {
		return collection.size() != rowSize;
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
