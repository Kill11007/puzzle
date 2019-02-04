package com.puzzle.spring.structure;

public class ResultSetImpl<T> implements ResultSet<T> {

	private T result;
	
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public void add(T result, Row<T> row) {
		this.result = result;
		row.setResult(result);
	}

	public void add(T result, Column<T> column) {
		this.result = result;
		column.setResult(result);
	}

}
