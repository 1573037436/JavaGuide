package com.designpattern.builder;
/**
 * 生产部件和组装部件
 * @author zhoucheng
 *
 */
public interface Builder {
	
	void builderPartA();
	void builderPartB();
	void builderPartC();
	//实现解耦过程和部件
	Product getResult();
}
