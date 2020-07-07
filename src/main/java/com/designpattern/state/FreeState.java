package com.designpattern.state;

public class FreeState implements State {

	@Override
	public void handle() {
		
		System.out.println("房间空闲中，可以入住");
	}

}
