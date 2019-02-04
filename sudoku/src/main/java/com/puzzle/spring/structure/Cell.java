package com.puzzle.spring.structure;

public interface Cell<T> {
	boolean isEmpty();
	void put(T value);
	Object delete();
}
