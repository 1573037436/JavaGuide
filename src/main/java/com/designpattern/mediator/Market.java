package com.designpattern.mediator;

public class Market implements Department {
private Mediator mediator;//持有终结者（总经理）的引用
	
	public Market(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("market", this);
	}	

	@Override
	public void outAction() {
		System.out.println("汇报工作，项目承接的进度，请求资金支持");
		mediator.command("finacial");
	}

	@Override
	public void selfAction() {
		System.out.println("跑市场接项目");
	}
}
