package com.designpattern.template;

public abstract class TemplateMethod {
	public void quhao(){
		System.out.println("取号排队");
	}
	abstract void transact();//具体的业务操作（钩子方法）
	public void fankui(){
		System.out.println("反馈评分");
	}
	public final void process(){
		this.quhao();
		this.transact();
		this.fankui();
	}
}
