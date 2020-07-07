package com.designpattern.staticproxy;
/**
 * 代理模式:给某一个对象提供一个代理对象，并由代理对象控制对源对象的引用。
 * 代理就是一个人或一个机构代表另一个人或者一个机构采取行动。某些情况下，
 * 客户不想或者不能够直接引用一个对象，代理对象可以在客户和目标对象直接起到中介的作用。
 * 客户端分辨不出代理主题对象与真实主题对象。代理模式可以并不知道真正的被代理对象，
 * 而仅仅持有一个被代理对象的接口，这时候代理对象不能够创建被代理对象，
 * 被代理对象必须有系统的其他角色代为创建并传入。
 * @author zhoucheng
 *
 */
public class Client {
	public static void main(String[] args) {
		Star star=new RealStar();
		Star proxyStar=new ProxyStar(star);
		proxyStar.confer();
		proxyStar.signcontract();
		proxyStar.bookticket();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
