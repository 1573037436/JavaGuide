package com.designpattern.strategy;
/**
 * Context：上下文角色，引用策略接口对象，屏蔽了外部模块对策略或方法的直接访问，只能通过Context 提供的方法访问。
 * @author zzj
 * @date 2020年1月14日
 */
public class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	public void printPrice(double s){
		System.out.println("您该报价"+strategy.getDiscount(s));
	}
}
