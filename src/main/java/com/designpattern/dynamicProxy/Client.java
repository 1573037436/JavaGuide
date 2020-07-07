package com.designpattern.dynamicProxy;

import java.lang.reflect.Proxy;
/**
 * 动态代理
 * JDK自带的动态代理
 * java.lang.reflect.Proxy作用：动态生成代理类和对象
 * java.lang.reflect.invocationHandler(处理器接口)
 * 作用：可以通过invoke方法对真实角色的代理访问
 * 每次生成proxy代理对象时都要指定对应的处理器对象
 * @author zhoucheng
 *
 */
public class Client {
	public static void main(String[] args) {
		Star star=new RealStar();
		StarHandle starHandle=new StarHandle(star);
		Star proxyStar=(Star)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},starHandle);
		proxyStar.bookticket();
		proxyStar.sing();
	}
}
