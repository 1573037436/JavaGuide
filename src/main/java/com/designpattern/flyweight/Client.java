package com.designpattern.flyweight;
/**
 * 享元模式的核心：享元模式以共享的方式高效的支持大量细粒度对象得重用
 * FLYWEIGHT在拳击比赛中指最轻量级。享元模式以共享的方式高效的支持大量的细粒度对象。
 * 享元模式能做到共享的关键是区分内蕴状态和外蕴状态。内蕴状态存储在享元内部，不会随环境的改变而有所不同。
 * 外蕴状态是随环境的改变而改变的。外蕴状态不能影响内蕴状态，它们是相互独立的。
 * 将可以共享的状态和不可以共享的状态从常规类中区分开来，将不可以共享的状态从类里剔除出去。
 * 客户端不可以直接创建被共享的对象，
 * 而应当使用一个工厂对象负责创建被共享的对象。享元模式大幅度的降低内存中对象的数量。
 * @author zhoucheng
 *优点：极大减少内存中对象的数量
 *外部状态相对独立，不影响内部状态
 *相同或相似对象，内存中只存一份，极大的节约资源，提高系统性能
 */
public class Client {

	
	public static void main(String[] args) {
		ChessFlyWeigth chess1=ChessFlyWeightFactory.getChessFlyWeigth("黑色");
		ChessFlyWeigth chess2=ChessFlyWeightFactory.getChessFlyWeigth("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		chess1.display(new Coordinate(10, 20));
		chess2.display(new Coordinate(10, 10));
		
	}

}