package com.designpattern.iterator;

public interface Myiterator {
	void first();//将游标指向第一个元素
	void next();//将游标指向下一个元素
	boolean hasNext();//是否存在下一个元素
	boolean isFirst();
	boolean isLast();
	Object getCurrentObj();//获得游标指向的当前对象
}
