package com.puzzle.spring.structure;

public class CellImpl<T> implements Cell<T>{
	private Row<T> row;
	private Column<T> column;
	private T value;
	private Integer putCount = 0;
	private boolean isFixed;

	public CellImpl() {
		
	}
	
	public CellImpl(Row<T> row,Column<T> column) {
		this();
		this.row = row;
		this.column = column;
	}
	
	public boolean isFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}
	
	public Row<T> getRow() {
		return row;
	}
	public void setRow(Row<T> row) {
		this.row = row;
	}
	public Column<T> getColumn() {
		return column;
	}
	public void setColumn(Column<T> column) {
		this.column = column;
	}
	public boolean isEmpty() {
		return value == null && column.isEmpty() && row.isEmpty();
	}
	public void put(T value) {
		row.setValue(value);
		column.setValue(value);
		this.value = value;
		putCount++;
		TableImpl.setCount(TableImpl.getCount() - 1);
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Integer getPutCount() {
		return putCount;
	}
	public void setPutCount(Integer putCount) {
		this.putCount = putCount;
	}
	public T delete() {
		T value = this.value;
		value = row.delete(value);
		column.delete(value);
		//putCount--;
		TableImpl.setCount(TableImpl.getCount() + 1);
		this.value = null;
		return value;
	}
}
