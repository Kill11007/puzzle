package com.puzzle.spring.structure;

public interface ResultSet<T> {
	void add(T value,Row<T> row);
	void add(T value,Column<T> column);

}
