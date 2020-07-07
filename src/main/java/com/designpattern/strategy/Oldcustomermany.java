package com.designpattern.strategy;

public class Oldcustomermany implements Strategy {

	@Override
	public double getDiscount(double standardprice) {
		System.out.println("打七折");
		return standardprice*0.7;
	}

}
