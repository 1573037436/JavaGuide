package com.designpattern.adapter;
/**
 * 适配器(组合的方式实现)
 * @author zhoucheng
 *
 */
public class Adapter2  implements Target {

	private Adaptee adaptee;
	@Override
	public void handlereq() {
         adaptee.request();		
	}
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

}

