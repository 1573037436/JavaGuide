package com.designpattern.mediator;
/**
 * 中介者模式的核心：解耦多个同事之间的交互关系，每个对象都持有中介者对象的引用，每个对象只跟中介者对象打交道
 * 通过中介者对象统一管理这些关系
 * 调停者模式包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用。
 * 从而使他们可以松散偶合。当某些对象之间的作用发生改变时，不会立即影响其他的一些对象之间的作用。
 * 保证这些作用可以彼此独立的变化。调停者模式将多对多的相互作用转化为一对多的相互作用。
 * 调停者模式将对象的行为和协作抽象化，把对象在小尺度的行为上与其他对象的相互作用分开处理。
 * 应用场景：MVC模式（其中的C，控制器就是一个中介者，M和V都和他打交道）
 * @author zhoucheng
 *
 */
public class Client {

	
	public static void main(String[] args) {
		Mediator mediator=new President();
		//Development development=new Development(mediator);
		Market market=new Market(mediator);
		Finacial finacial=new Finacial(mediator);
		market.selfAction();
		market.outAction();
	}

}
