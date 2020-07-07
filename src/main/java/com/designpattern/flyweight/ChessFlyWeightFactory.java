package com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author zhoucheng
 *
 */
public class ChessFlyWeightFactory {
	//享元池
	private static Map<String, ChessFlyWeigth> map=new HashMap<String, ChessFlyWeigth>();
	
	public static ChessFlyWeigth getChessFlyWeigth(String color){
		if (map.get(color)!=null) {
			return map.get(color);
		}else {
			concretechess css=new concretechess(color);
				map.put(color, css);
				return css;
		}
	}
}
