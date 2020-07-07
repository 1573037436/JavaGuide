package com.designpattern.chainOfrespon;



public abstract class Leader {
	protected String name;
	protected Leader nextLeader;//责任链上的后继对象
	public String getName() {
		return name;
	}
	//设置责任链上的后继对象
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	public Leader(String name) {
		super();
		this.name = name;
	}
	//处理请求的核心业务方法
	public abstract void handleRequest(LeaveRequest request);
	
}