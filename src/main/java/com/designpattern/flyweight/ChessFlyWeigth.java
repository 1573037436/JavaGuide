package com.designpattern.flyweight;

public interface ChessFlyWeigth {
	void setColor(String c);
	String getColor();
	void display(Coordinate c);
}
class concretechess implements ChessFlyWeigth{
	private String color;
	
	public concretechess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("棋子颜色"+color);
		System.out.println("棋子位置"+c.getX()+"*****"+c.getY());
	}

	@Override
	public String getColor() {
		return color;
	}


	@Override
	public void setColor(String c) {
		this.color=c;
	}
	
}
