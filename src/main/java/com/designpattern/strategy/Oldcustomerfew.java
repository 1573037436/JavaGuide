package com.designpattern.strategy;

public class Oldcustomerfew implements Strategy {

	@Override
	public double getDiscount(double standardprice) {
		System.out.println("打八折");
		return standardprice*0.8;
	}

}
