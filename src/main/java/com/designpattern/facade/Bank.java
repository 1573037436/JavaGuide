package com.designpattern.facade;

public interface Bank{
	void kaiHu();
}
class haiDianBank implements Bank{

	@Override
	public void kaiHu() {
		System.out.println("到海淀银行办理开户手续");
		
	}
	
}
