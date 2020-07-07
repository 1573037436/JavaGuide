package com.designpattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandle implements InvocationHandler {
	Star realStar;
	
	public StarHandle(Star star) {
		super();
		this.realStar = star;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
	throws Throwable {
		Object object=null;
		System.out.println("真正的方法执行前");
		System.out.println("面谈，签合同，订票");
		if (method.getName().equals("sing")) {
			object=method.invoke(realStar, args);
		}
		System.out.println("真正的方法执行后");
	    System.out.println("收尾款");
		return object;
	}

}
