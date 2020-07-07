package com.designpattern.mediator;

public class Development implements Department {
private Mediator mediator;//持有终结者（总经理）的引用
	
	public Development(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("development", this);
	}	

	@Override
	public void outAction() {
		System.out.println("汇报工作，没钱了，请求资金支持");
	}

	@Override
	public void selfAction() {
		System.out.println("专心科研，开发项目");
	}

}
