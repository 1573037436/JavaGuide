package com.designpattern.chainOfrespon;



public class LeaveRequest {
	private String name;//姓名
	private int leaveDays;//请假天数
	private String reason;//原因
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	//请假信息
	public LeaveRequest(String name, int leaveDays, String reason) {
		super();
		this.name = name;
		this.leaveDays = leaveDays;
		this.reason = reason;
	}
	
}
