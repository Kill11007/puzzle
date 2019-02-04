package com.puzzle.spring.structure;

import java.util.Collection;

import com.puzzle.spring.factory.CellImplFactory;
import com.puzzle.spring.factory.ColumnImplFactory;
import com.puzzle.spring.factory.RowImplFactory;

public class TableImpl<T> implements Table<T> {
	private Row<T>[] rows;
	private Column<T>[] columns;
	private CellImpl<T>[][] cells;
	private Collection<T> collection;
	private static Integer count;

	public static Integer getCount() {
		return count;
	}

	public static void setCount(Integer count) {
		TableImpl.count = count;
	}

	public TableImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public TableImpl(int rows,int columns,Collection<T> collection) {
		this.collection = collection;
		this.rows = createRows(rows);
		this.columns =createColumns(columns);
		this.cells = createCells(this.rows, this.columns);
		TableImpl.count = rows * columns;
	}
	
	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	public Row<T>[] getRows() {
		return rows;
	}

	public void setRows(Row<T>[] rows) {
		this.rows = rows;
	}

	public Column<T>[] getColumns() {
		return columns;
	}

	public void setColumns(Column<T>[] columns) {
		this.columns = columns;
	}

	public CellImpl<T>[][] getCells() {
		return cells;
	}

	public void setCells(CellImpl<T>[][] cells) {
		this.cells = cells;
	}

	public boolean isEmpty() {
		return TableImpl.count != 0;
	}

	@SuppressWarnings("unchecked")
	private Row<T>[] createRows(int count) {
		rows = new Row[count];
		for(int i = 0; i < rows.length ; i++) {
			rows[i] = RowImplFactory.createRow();
			rows[i].setRowSize(count);
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	private Column<T>[] createColumns(int count) {
		columns = new Column[count];
		for(int i = 0 ; i < columns.length ; i++) {
			columns[i] = ColumnImplFactory.createColumn();
			columns[i].setColumnSize(count);
		}
		return columns;
	}

	private CellImpl<T>[][] createCells(Row<T>[] rows, Column<T>[] columns) {
		@SuppressWarnings("unchecked")
		CellImpl<T>[][] cells = new CellImpl[rows.length][columns.length];
		for(int i = 0; i < cells.length ; i++) {
			for(int j = 0 ; j < cells[i].length ; j++) {
				cells[i][j] = CellImplFactory.createCell(rows[i], columns[j]);
			}
		}
		return cells;
	}

}
