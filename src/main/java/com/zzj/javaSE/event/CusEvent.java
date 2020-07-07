package com.zzj.javaSE.event;

import java.util.EventObject;
/**
 * 事件类,用于封装事件源及一些与事件相关的参数.
 * @author zzj
 * @date 2020年1月7日
 */
public class CusEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	/**
	 * 事件源
	 */
    private Object source;
	@Override
	public Object getSource() {
		return source;
	}
	public void setSource(Object source) {
		this.source = source;
	}
	public CusEvent(Object source) {
		super(source);
		this.source=source;
	}
	
}
