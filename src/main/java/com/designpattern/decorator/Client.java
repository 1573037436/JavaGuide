package com.designpattern.decorator;
/**
 * 装饰模式的功能：动态的为一个对象添加功能
 * 装饰模式是一种代替继承的技术，无需通过继承增加子类就能扩展对象的新功能
 * 使用对象的关联关系代替继承关系，更加灵活，同时避免类型体系的快速膨胀
 * @author zhoucheng
 *应用场景：IO中输入流和输出流的设计
 */
public class Client {

	public static void main(String[] args) {
		Car car=new Car();
		//car.move();
		FlyCar flyCar=new FlyCar(car);//增加天上飞的功能
		WaterCar waterCar=new WaterCar(flyCar);//增加水中游的功能
		AICar aiCar=new AICar(waterCar);//增加人工智能的功能
		aiCar.move();
		System.out.println("***********************************************");
		AICar aiCar2=new AICar(new FlyCar(new WaterCar(car)));
		aiCar2.move();
		System.out.println("*********************************************");		
	}

}
