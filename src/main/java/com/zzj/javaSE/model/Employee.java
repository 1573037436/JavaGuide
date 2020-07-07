package com.zzj.javaSE.model;

import java.util.Optional;

public class Employee implements Cloneable {
	private String name;
	private int age;
	private char sex;
	private int salary;
	private Address address;
	private String password;

	public Employee(String name, int age, char sex, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
	}

	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	public Employee(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Employee() {
		super();
	}

	// 实现浅克隆
	@Override
	public Object clone(){
		Employee employee = null;
		try {
			employee = (Employee) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//此处实现深克隆
		//employee.address = (Address) address.clone();
		return employee;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Optional<String> getPassword(){
		 return Optional.ofNullable(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sex=" + sex + ", salary=" + salary + ", address="
				+ address + "]";
	}

	
}
