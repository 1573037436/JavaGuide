package com.zzj.javaSE.event;

import java.util.EventListener;
/**
 * 监听器
 * @author zzj
 * @date 2020年1月7日
 */
public class CusEventListener implements EventListener {

	/**
	 * 事件发生后的回调方法
	 * @param e
	 */
	public void fireCusEvent(CusEvent e){
	        EventSourceObject eObject=(EventSourceObject)e.getSource();
			System.out.println("My name has been changed!");
			System.out.println("I got a new name,named \""+eObject.getName()+"\"");
	    }
	}
