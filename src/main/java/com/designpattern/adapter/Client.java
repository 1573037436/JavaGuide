package com.designpattern.adapter;
/**
 * 把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口原因不匹配而无法一起工作的两个类能够一起工作。
 * 适配类可以根据参数返还一个合适的实例给客户端
 * @author zhoucheng
 *
 */
public class Client {
	public void test(Target t){
		t.handlereq();
	}
	public static void main(String[] args) {
		Client client=new Client();
		//被适配对象
		Adaptee adaptee=new Adaptee();
		//Target target=new Adapter();
		//适配器
		Target target=new Adapter2(adaptee);
		 client.test(target);
	}
}

