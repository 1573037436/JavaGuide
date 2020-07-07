package com.designpattern.dynamicProxy;
/**
 * 真实角色
 * @author zhoucheng
 *
 */
public class RealStar implements Star{

	@Override
	public void bookticket() {
		System.out.println("RealStar.bookticket()");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney()");
	}

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}

	@Override
	public void signcontract() {
		System.out.println("RealStar.signcontract()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar.sing()");
	}

}
