package com.designpattern.strategy;

public class Newcustomerfew implements Strategy {

	@Override
	public double getDiscount(double standardprice) {
		System.out.println("不打折，原价");
		return standardprice;
	}

}
