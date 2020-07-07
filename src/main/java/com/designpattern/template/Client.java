package com.designpattern.template;
/**
 * 模板方法模式准备一个抽象类，将部分逻辑以具体方法以及具体构造子的形式实现，
 * 然后声明一些抽象方法来迫使子类实现剩余的逻辑。不同的子类可以以不同的方式实现这些抽象方法，
 * 从而对剩余的逻辑有不同的实现。先制定一个顶级逻辑框架，而将逻辑的细节留给具体的子类去实现。
 * 应用场景：数据库访问的封装
 * junit单元测试
 * servlet中关于doGet/doPost方法调用
 * spring中JDBCTemplate,HibernateTemplate等
 *
 */
public class Client {

	
	public static void main(String[] args) {
		
		TemplateMethod method=new quMoney();
		method.process();
		
		//匿名内部内
		TemplateMethod method2=new TemplateMethod() {
			
			@Override
			void transact() {
				System.out.println("我要存钱");
				
			}
		};
		method2.process();
	}

}
 class quMoney extends TemplateMethod{

	@Override
	void transact() {
		System.out.println("我要取钱");
		
	}
	
}
 