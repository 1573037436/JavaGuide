package com.designpattern.builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}
	//将部件partA,partB,partC最后组装成对象
	public void construct(){
		builder.builderPartA();
		builder.builderPartB();
		builder.builderPartC();
	}

}
