package com.designpattern.staticproxy;
/**
 * 代理角色
 * @author zhoucheng
 *
 */
public class ProxyStar implements Star{
    Star star;
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}

	@Override
	public void bookticket() {
		System.out.println("ProxyStar.bookticket()");
	}

	@Override
	public void collectMoney() {
		System.out.println("ProxyStar.collectMoney()");
	}

	@Override
	public void confer() {
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signcontract() {
		System.out.println("ProxyStar.signcontract()");
	}

	@Override
	public void sing() {
		//真实角色的动作
		star.sing();
		System.out.println("RealStar.sing()");
	}

}
