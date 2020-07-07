package com.designpattern.command;
//调用者/执行者
public class Invoke {
	private Command command;//也可通过容器容纳一些命令，进行批处理，数据库底层的事务管理就是类似的结构

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//用于调用命令类的业务方法
	public void call(){
		command.execute();
	}
}