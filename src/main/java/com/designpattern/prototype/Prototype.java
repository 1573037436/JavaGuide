package com.designpattern.prototype;

public class Prototype implements Cloneable{
	 private String name;
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getName() {
	        return this.name;
	    }
	    //克隆自身的方法
	    public Object clone(){
	        try {
	            return super.clone();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
