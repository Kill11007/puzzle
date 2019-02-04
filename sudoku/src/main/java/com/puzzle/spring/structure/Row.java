package com.puzzle.spring.structure;

import java.util.Collection;

public interface Row<T>{
	boolean isEmpty();
	boolean setValue(T value);
	T delete(T value);
	void setResult(T result);
	void setCollection(Collection<T> collection);
	void setRowSize(Integer rowSize);
}
