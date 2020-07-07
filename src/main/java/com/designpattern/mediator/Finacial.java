package com.designpattern.mediator;
/**
 * 财务部
 * @author zhoucheng
 *
 */
public class Finacial implements Department {
	private Mediator mediator;//持有终结者（总经理）的引用
	
	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("finacial", this);
	}	

	@Override
	public void outAction() {
		System.out.println("汇报工作，钱太多，要怎么花");
	}

	@Override
	public void selfAction() {
		System.out.println("数钱");
	}

}
