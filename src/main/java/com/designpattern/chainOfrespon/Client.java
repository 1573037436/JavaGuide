package com.designpattern.chainOfrespon;


/**
 * 在责任链模式中，很多对象由每一个对象对其下家的引用而接 起来形成一条链。
 * 请求在这个链上传递，直到链上的某一个对象决定处理此请求。
 * 客户并不知道链上的哪一个对象最终处理这个请求，系统可以在不影响客户端的情况下动态的重新组织链和分配责任。
 * 处理者有两个选择：承担责任或者把责任推给下家。一个请求可以最终不被任何接收端对象所接受。 
 * 应用场景：一场极致就是一种责任链模式，一个try块可以对应多个catch块，当第一个catch不匹配类型，则自动跳到下一个catch
 * struts2中的拦截器的调用也是典型的责任链模式
 * servlet中过滤器的链式处理
 * 
 */
public class Client {

	
	public static void main(String[] args) {
		Leader oneLeader=new Director("张三");
		Leader twoLeader=new Manager("李四");
		Leader threeLeader=new GeneralManager("王五");
		//设置责任链之间的关系
		oneLeader.nextLeader=twoLeader;
		twoLeader.nextLeader=threeLeader;
		
		LeaveRequest request=new LeaveRequest("吉姆",15,"回美国结婚");
		oneLeader.handleRequest(request);
	}

}
