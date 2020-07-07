package com.designpattern.memento;
/**
 * 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。备忘录模式的用意是在不破坏封装的条件下，
 * 将一个对象的状态捉住，并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起来的状态。 
 * @author zhoucheng
 *应用场景：数据库软件中，事务管理中，回滚操作
 *普通软件中，撤销操作
 */
public class Client {
public static void main(String[] args) {
	CareTaker taker=new CareTaker();
	Emp emp=new Emp("张三", 20, 2000);
	System.out.println("第一次打印对象"+emp.getEname()+"*******"+emp.getAge()+"*******"+emp.getSalary());
	taker.setMemento(emp.memento());//备忘一次
	
	emp.setAge(30);
	emp.setEname("李四");
	emp.setSalary(1000);
	System.out.println("第二次打印对象"+emp.getEname()+"*******"+emp.getAge()+"*******"+emp.getSalary());
	emp.recovery(taker.getMemento());//恢复备忘录对象保存的状态
	System.out.println("第三次打印对象"+emp.getEname()+"*******"+emp.getAge()+"*******"+emp.getSalary());
}
}
