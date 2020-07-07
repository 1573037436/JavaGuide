package com.designpattern.facade;
/**
 *外观模式的核心：为子系统提供统一的入口，封装子系统的复杂性，便于客户端调用
 * 外部与一个子系统的通信必须通过一个统一的门面对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。
 * 每一个子系统只有一个门面类，而且此门面类只有一个实例，也就是说它是一个单例模式。但整个系统可以有多个门面类。
 * @author zhoucheng
 *
 */
public class Client {

	
	public static void main(String[] args) {
		new RegistFacade().regist();
	}

}
