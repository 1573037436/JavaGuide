package com.designpattern.mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {
	private Map<String, Department> map=new HashMap<String, Department>();
	@Override
	public void command(String name) {
		map.get(name).selfAction();
	}

	@Override
	public void register(String name, Department t) {
		map.put(name, t);
	}

}
