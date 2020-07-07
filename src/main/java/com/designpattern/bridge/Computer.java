package com.designpattern.bridge;

public class Computer {
	protected Brand brand;
	
	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}

	void salecom(){
		System.out.println("销售电脑");
	}
}
class Desktop extends Computer{

	public Desktop(Brand brand) {
		super(brand);
		brand.sale();
	}
	@Override
	void salecom() {
		System.out.println("销售台式电脑");
	}
	
}
class Laptop extends Computer{

	public Laptop(Brand brand) {
		super(brand);
		brand.sale();
	}
	@Override
	void salecom() {
		System.out.println("销售笔记本电脑");
	}
	
}
