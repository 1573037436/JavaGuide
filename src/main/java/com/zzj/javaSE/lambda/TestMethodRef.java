package com.zzj.javaSE.lambda;


import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.zzj.javaSE.model.Employee;

/** 三种语法格式
* Consumer, Supplier,Function的用法
* 1.对象 :: 实例方法名
*
* 2.类 :: 静态方法名
*
* 3.类 :: 实例方法名
*/
public class TestMethodRef {
	 @Test
    public void test1() {

        Consumer<String> consumer = (x)-> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> son =  ps::println;

    }

	 @Test
    public void test2() {
        Employee emp = new Employee("Yan", 24, '男', 14000);
        Supplier<String> sup = emp::getName;
       /* Supplier<String> sup2 = new Supplier<String>() {
            @Override
            public String get() {
               return emp.getName();
            }
        };*/

//	     与上面语句功能相同    Supplier sup2 = ()->emp.getName();
        String s = sup.get();
        System.out.println(s);
    }


    //类 :: 静态方法
    @Test
    public void test3() {
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = Integer::compare;
    }


    //类 :: 实例方法名

    @Test
    public void test4() {
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

        //限制条件：只有当(x, y) -> x.equals(y) 第一个参数x作为参数的调用者，第二个参数y为方法参数时，才可以使用这种方式
        //ClassName::method
        BiPredicate<String, String> bp2 = String::equals;
    }


    //构造器引用 ClassName::new
    @Test
    public void test5() {
        Supplier<Employee> sup1 = () -> new Employee();
        Employee employee = sup1.get();//接口sup1 调用方法 get()  get方法被() -> new Employee() 重写

        //调用无参构造器  因为 需要和Supplier get方法中的入参和返回值类型保持一致
        Supplier<Employee> sup2 = Employee::new;


        //如需使用其他构造器则
        BiFunction<String, Integer, Employee> bg1 = (x, y) -> new Employee(x, y);
        System.out.println(bg1.apply("Yan", 23));

        //调用有参构造器，取决于BiFunction中的apply方法的入参
        BiFunction<String, Integer, Employee> bg2 = Employee::new;

    }


    //数组引用 type[] :: new
    @Test
    public void test6() {
        Function<Integer, String[]> fun1 = (x) -> new String[x];
        String[] apply = fun1.apply(10);
        System.out.println(apply);

        Function<Integer, String[]> fun2 = String[]::new;

    }
}
