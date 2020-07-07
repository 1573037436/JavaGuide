package com.designpattern.command;

public interface Command {
	void execute();
}
 class ConcreteCommand implements Command{
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//命令真正执行前或后，执行相关的操作
		receiver.receive();
	}
}