package com.zzj.javaSE.object.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

/**
 * 如果成员变量包括引用类型，在克隆时则需要深克隆
 * 实现深克隆的方法：
 * 1、深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象
 * 2、将对象进行串行化实现深克隆
 * @author Administrator
 *
 */
public class DeepnessClone {

	public static void main(String[] args) {
		try {
			Address address=new Address();//address为可变的引用类型
			address.setState("中国");
			address.setProvince("湖北");
			address.setCity("武汉");
			Employee employee=new Employee("张珊", 20, address);
			Employee employee2=(Employee) employee.deepClone();
			employee2.setName("李四");
			employee2.setAge(15);
			employee2.getAddress().setState("法国");
			employee2.getAddress().setProvince("巴黎");
			employee2.getAddress().setCity("小城");
			System.out.println(employee+"******");
			System.out.println(employee2);	
		} catch (Exception e) {
		}
	}

}

class Employee implements Serializable{
	private String name;
	private int age;
	private Address address;
	
	
	public Employee(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//将对象写入流中，再从流中读出来
	public Object deepClone() throws IOException, OptionalDataException,
	            ClassNotFoundException {
	        // 将对象写到流里
	        ByteArrayOutputStream bo = new ByteArrayOutputStream();
	        ObjectOutputStream oo = new ObjectOutputStream(bo);
	        oo.writeObject(this);
	        // 从流里读出来
	        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
	        ObjectInputStream oi = new ObjectInputStream(bi);
	        return (oi.readObject());
	    }
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
}

class Address implements Serializable{
	private String state;//国家
	private String province;//省
	private String city;//市
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", province=" + province + ", city=" + city + "]";
	}
	
}

