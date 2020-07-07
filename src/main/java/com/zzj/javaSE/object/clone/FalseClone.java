package com.zzj.javaSE.object.clone;

import com.zzj.javaSE.model.Employee;
/**
 * =号只是修改了引用，并没有赋值堆中的对象
 * 此时两个引用指向同一个对象，如果一个变量对对象进行修改，
 * 另一个变量也会跟着改变
 * @author Administrator
 *
 */
public class FalseClone {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("张珊");
		employee.setAge(20);
		//等号代表浅克隆
		Employee employee2 = employee;
		employee2.setName("李思");
		employee2.setAge(22);
		System.out.println("employee"+employee+"   employee2"+employee2);

	}

}
