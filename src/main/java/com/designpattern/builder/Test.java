package com.designpattern.builder;
/**
 * 将产品的内部表象和产品的生成过程分割开来，从而使一个建造过程生成具有不同的内部表象的产品对象。
 * 建造模式使得产品内部表象可以独立的变化，客户不必知道产品内部组成的细节。
 * 建造模式可以强制实行一种分步骤进行的建造过程。
 * @author zhoucheng
 *
 */
public class Test {

	
	public static void main(String[] args) {
		ConcreteBuilder builder=new ConcreteBuilder();
		Director dire=new Director(builder);
		//缁勮浜у搧
		dire.construct();
		//鑾峰緱浜у搧
		Product product=builder.getResult();
		//鎵撳嵃浜у搧
		System.out.println(product);
	}

}
