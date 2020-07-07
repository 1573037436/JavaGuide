package com.zzj.javaSE.object.clone;

import com.zzj.javaSE.model.Employee;
import com.zzj.javaSE.model.Address;

/**
 * 若不对clone()方法进行改写，则调用此方法得到的对象即为浅拷贝
 * 如果对象的成员变量不包括可变的引用类型，则可以使用浅克隆
 * 浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象
 * @author Administrator
 *
 */
public class ShallownessClone {

	public static void main(String[] args) {
		Address address=new Address();//address为可变的引用类型
		address.setState("中国");
		address.setProvince("湖北");
		address.setCity("武汉");
		Employee employee=new Employee("张珊", 20, address);
		//淺克隆
		Employee employee2=(Employee) employee.clone();
		employee2.setName("李四");
		employee2.setAge(15);
		employee2.getAddress().setState("法国");
		employee2.getAddress().setProvince("巴黎");
		employee2.getAddress().setCity("小城");
		System.out.println(employee+"******");
		System.out.println(employee2);
	}

}
