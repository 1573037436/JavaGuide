package com.designpattern.state;

public class CheckedinState implements State {

	@Override
	public void handle() {
		
		System.out.println("房间已入住，请勿打扰");
	}

}
