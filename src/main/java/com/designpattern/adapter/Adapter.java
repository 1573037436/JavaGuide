package com.designpattern.adapter;
/**
 * 适配器(继承的方式实现)
 * @author zhoucheng
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void handlereq() {
         super.request();		
	}

}
