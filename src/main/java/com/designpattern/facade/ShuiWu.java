package com.designpattern.facade;

public interface ShuiWu {
	void jiaoShui();//办理缴税登记
}
class HaidianShuiWu implements ShuiWu{

	@Override
	public void jiaoShui() {
		System.out.println("办理缴税登记");
		
	}
	
}