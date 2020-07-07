package com.designpattern.state;

public class BookState implements State {

	@Override
	public void handle() {
		System.out.println("房间已预订，其他人不能预定");
		
	}

}
