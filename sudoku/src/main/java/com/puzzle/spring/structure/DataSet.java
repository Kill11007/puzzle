package com.puzzle.spring.structure;

public interface DataSet<T> {
	boolean add(T value);
	boolean isEmpty();
	boolean delete(T value);
	boolean contains(T value);
}
