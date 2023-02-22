package com.listofcreate;

public interface IMyList<T> {

	void add(T data);

	void grow();

	void getIndex(int index);

	boolean setValue(int index, T value);

	String toString();

	void remove(T value);

	int indexOf(T data);

	int lastİndexOf(T data);

	boolean isEmpty();

	T[] toArray();

	void clear();

	List<T> sublist(int start, int finish);

	boolean includes(T data);

}
