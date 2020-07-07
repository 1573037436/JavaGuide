package com.zzj.javaSE.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Lambda表达式（也称为闭包）是Java 8中最大和最令人期待的语言改变。
 * 它允许我们将函数当成参数传递给某个方法，或者把代码本身当作数据处理
 * java内置四大核心函数式接口
 * <p>
 * 1.Consumer<T>消费型接口 无返回值  void accept（T t）
 * 2.Supplier<T>供给型接口 T get();
 * 3.Function<T>函数型接口 R apply(T t)
 * 4.Predicate<T>断言型接口 用于做判断操作 boolean test(T t)
 */
public class LambdaTest {
	 //Consumer<T>
    @Test
    public void test1() {
        //happy(10.15, (x) -> System.out.println(x));
    	String[] atp = {"Rafael Nadal", "Novak Djokovic",  
    		       "Stanislas Wawrinka",  
    		       "David Ferrer","Roger Federer",  
    		       "Andy Murray","Tomas Berdych",  
    		       "Juan Martin Del Potro"}; 
    		//ArrayList<E> extends AbstractList<E>,其实ArrayList并不是我们平时用的ArrayList。
    		//而是Arrays里面的一个内部类。而且这个内部类没有add，clear，remove方法，
    		//所以抛出的异常其实来自于AbstractList
    		//传递的数组必须是对象数组，而不是基本类型
    		//总结:
    		//1、Arrays.asList()不要乱用，asList方法只适合转换成List之后进行读取的基本操作,底层其实还是数组。

    		//2、如果使用了Arrays.asList()的话，最好不要使用其集合的操作方法。

    		//3、List list = new ArrayList<>(Arrays.asList("a", "b", "c"))可以在外面这样包一层真正的ArrayList。
    		List<String> players =  Arrays.asList(atp);  
    		  
    		// 以前的循环方式  
    		/*for (String player : players) {  
    		     System.out.print(player + "; ");  
    		} */ 
    		  
    		// 使用 lambda 表达式以及函数操作(functional operation)  
    		//players.forEach((a) -> System.out.print(a + "; "));  
    		   
    		// 在 Java 8 中使用双冒号操作符(double colon operator)  
    		//players.forEach(System.out::println); 
    		//输出list中匹配的值
    		String bString=players.stream().filter(x->x=="Rafael Nadal").findAny().get();
    		System.out.println(bString);
    		
    		List<String> stringCollection=new ArrayList<>();
    		stringCollection.add("bbbb");
    		stringCollection.add("bcccc");
    		stringCollection.add("baaaa");
    		//排序
    		List<String> afterSorted=stringCollection.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
    		System.out.println("排序后新的list-----------------------------");
    		afterSorted.stream().forEach(x->System.out.println(x));
    		System.out.println("排序后原来的list-----------------------------");
    		stringCollection.stream().forEach(x->System.out.println(x));
    		//匹配任一个，返回boolean值
    		boolean anyStartsWithA = 
    			    stringCollection
    			        .stream()
    			        .anyMatch((s) -> s.startsWith("a"));
    			System.out.println(anyStartsWithA);      
    		//匹配所有
			boolean allStartsWithA = 
			    stringCollection
			        .stream()
			        .allMatch((s) -> s.startsWith("b"));
			System.out.println(allStartsWithA);     
			//反向匹配
			boolean noneStartsWithZ = 
			    stringCollection
			        .stream()
			        .noneMatch((s) -> s.startsWith("z"));
			System.out.println(noneStartsWithZ);    


    }

    //happy
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //Supplier<T> 产生指定个数的随机数,存入集合
    @Test
    public void test2() {
    	this.getNumber(10, () -> (int) (Math.random() * 100));
    }

    public List<Integer> getNumber(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
        	list.add(sup.get());
        }
        //过滤掉小于50的数字
        Stream liStream=list.stream().filter(a->a>50);
        list=(List<Integer>) liStream.collect(Collectors.toList());
        
        //循环输出list
        list.forEach(a->System.out.print(a + "; "));
        return list;
    }


    //Predicate<T>
    @Test
    public void test3() {
        List<String> strList = Arrays.asList("Mike", "Lee", "Yan");
        //返回满足条件的集合
        List<String> list=strList.stream().filter((x) -> x.length() > 3).collect(Collectors.toList());
        
        //使用时设置条件
        //List<String> list = this.filterStr(strList, (x) -> x.length() > 3);
        list.forEach(System.out::print);
    }

    //将满足条件的字符串 存入集合中
    public List<String> filterStr(List<String> str, Predicate<String> pre) {
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if (pre.test(s)) {
                list.add(s);
            }
        }
        return list;
    }
    //串行和并行的测试
    @Test
    public void parallelstream(){
    	int max = 1000000;
    	List<String> values = new ArrayList<>(max);
    	for (int i = 0; i < max; i++) {
    	    UUID uuid = UUID.randomUUID();
    	    values.add(uuid.toString());
    	}
    	long t0 = System.nanoTime();
    	long count = values.stream().sorted().count();
    	System.out.println("串行排序 -------------"+count);
    	long t1 = System.nanoTime();
    	long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    	System.out.println(String.format("sequential sort took: %d ms", millis));
    	//并行排序：
    	long parallelt0 = System.nanoTime();
    	long parallelcount = values.parallelStream().sorted().count();
    	System.out.println("并行排序--------------"+parallelcount);
    	long parallelt1 = System.nanoTime();
    	long parallelmillis = TimeUnit.NANOSECONDS.toMillis(parallelt1 - parallelt0);
    	System.out.println(String.format("parallel sort took: %d ms", parallelmillis));
    }
}
