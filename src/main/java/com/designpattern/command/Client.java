package com.designpattern.command;
/**
 * 命令模式把一个请求或者操作封装到一个对象中。
 * 命令模式把发出命令的责任和执行命令的责任分割开，委派给不同的对象。
 * 命令模式允许请求的一方和发送的一方独立开来，使得请求的一方不必知道接收请求的一方的接口，
 * 更不必知道请求是怎么被接收，以及操作是否执行，何时被执行以及是怎么被执行的。系统支持命令的撤消。 
 * 应用场景：struts2中，action的整个调用过程就有命令模式
 * @author zhoucheng
 *
 */
public class Client {

	public static void main(String[] args) {
		Command command=new ConcreteCommand(new Receiver());
		Invoke invoke=new Invoke(command);
		invoke.call();
	}

}
