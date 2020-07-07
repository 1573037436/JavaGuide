package com.designpattern.observer;
/**
 * 观察者模式定义了一种一队多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态上发生变化时，
 * 会通知所有观察者对象，使他们能够自动更新自己。
 * @author zhoucheng
 *应用场景：聊天室程序的，服务器转发给所有客户端
 *Servlet中，监听器的实现
 */
public class Client {
public static void main(String[] args) {
	ConcreteSubject ccst=new ConcreteSubject();
	//创建多个观察者
	ObserverA obsa=new ObserverA();
	ObserverA obsa1=new ObserverA();
	ObserverA obsa2=new ObserverA();
	//将这三个观察者添加到subject对象的观察着队伍中
	ccst.registerObserver(obsa);
	ccst.registerObserver(obsa1);
	ccst.registerObserver(obsa2);
	//改变subject的状态
	ccst.setState(200);
	//观察观察者的状态是否发生了变化
	System.out.println(obsa.getMyState());
	System.out.println(obsa1.getMyState());
	System.out.println(obsa2.getMyState());
}
}

