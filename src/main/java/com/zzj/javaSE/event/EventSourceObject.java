package com.zzj.javaSE.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 事件源
 * @author zzj
 * @date 2020年1月7日
 */
public class EventSourceObject{
	private String name;
	/**
	 * 监听器容器  list或set
	 */
	private Set<CusEventListener> listeners;
	public EventSourceObject(){
		super();
		listeners=new HashSet<>();
	}

	/**
	 * 给事件源注册监听器
	 * @param cel
	 */
	public void addCusListener(CusEventListener cel){
		listeners.add(cel);
	}

	/**
	 * 当事件发生时,通知注册在该事件源上的所有监听器做出相应的反应（调用回调方法）
	 */
	protected void notifies(){
		CusEventListener cel=null;
		Iterator<CusEventListener> iter=listeners.iterator();
		while(iter.hasNext()){
			cel=iter.next();
			cel.fireCusEvent(new CusEvent(this));
		}
	}
	/**
	 * 模拟事件触发器，当成员变量name的值发生变化时，触发事件。
	 * @param name
	 */
	public void setName(String name) {
		if (!name.equals(this.name)) {
			this.name = name;
			notifies();
		}
	}
	public String getName() {
		return name;
	}
	
}
