package com.designpattern.builder;
/**
 * 通过实现接口Builder来具体实现构建或装配产品的部件
 * @author zhoucheng
 *
 */
public class ConcreteBuilder implements Builder {
	
	Part partA,partB,partC;
	//创建部件A
	@Override
	public void builderPartA() {
		//这里具体如何构建partA
	}
	//创建部件B
	@Override
	public void builderPartB() {
		//这里具体如何构建partB
	}
	//创建部件C
	@Override
	public void builderPartC() {
		//这里具体如何构建partC
	}
	
	@Override
	public Product getResult() {
		//返回最后组装成品结果
       return null;
	}

}
