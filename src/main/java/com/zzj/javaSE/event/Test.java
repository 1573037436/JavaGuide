package com.zzj.javaSE.event;

public class Test {
	public static void main(String[] args) {
			EventSourceObject eObject=new EventSourceObject();
			//注册监听器
			eObject.addCusListener(new CusEventListener());
			//触发事件
			eObject.setName("张三");
	}

}
