package com.designpattern.strategy;

public class Newcustomermany implements Strategy {

	@Override
	public double getDiscount(double standardprice) {
		System.out.println("打九折");
		return standardprice*0.9;
	}

}
