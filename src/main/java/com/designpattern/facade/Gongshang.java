package com.designpattern.facade;

public interface Gongshang {
	void checkName();//核名
}
class HaidianGongshang implements Gongshang{

	@Override
	public void checkName() {
		System.out.println("检查名字是否有冲突");
		
	}
	
}
