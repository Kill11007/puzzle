package com.puzzle.spring.structure;

import java.util.Collection;
import java.util.LinkedList;

public class DataSetImpl<T> implements DataSet<T> {
	private Collection<T> collection;
	private LinkedList<T> dataList = new LinkedList<T>();
	
	public DataSetImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public DataSetImpl(Collection<T> collection) {
		this.collection = collection;
	}
	
	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	public boolean add(T value) {
		dataList.add(value);
		return collection.add(value);
	}

	public boolean isEmpty() {
		return collection.isEmpty();
	}

	public T get() {
		T value = dataList.pollFirst();
		return value;
	}

	public boolean delete(T value) {
		return collection.remove(value);
	}

	public boolean contains(T value) {
		return collection.contains(value);
	}
	
}
