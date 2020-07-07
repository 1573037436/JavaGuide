package com.zzj.javaSE.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueTest {

	public QueueTest() {}
		/**
		 * 下表显示了jdk1.5中的阻塞队列的操作：
		 *　　add      增加一个元索                如果队列已满，则抛出一个IIIegaISlabEepeplian异常
		 *　　remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
		 *　　element  返回队列头部的元素          如果队列为空，则抛出一个NoSuchElementException异常
		 *　　offer    添加一个元素并返回true      如果队列已满，则返回false
		 *　　poll     移除并返问队列头部的元素    	如果队列为空，则返回null
		 *　　peek     返回队列头部的元素          如果队列为空，则返回null
		 *　　put      添加一个元素               如果队列满，则阻塞
		 *　　take     移除并返回队列头部的元素     如果队列为空，则阻塞
		 *
		 *
		 *   队列实现的三种方式(简单实现入队和出队)：
		 *	（1）通过数组实现一个队列；
		 *	（2）通过集合实现一个对列；
		 *	（3）通过两个堆栈实现一个队列。
		 */
		public static void main(String[] args) {
			//用数组实现的queue
			QueueFromArray queue=new QueueFromArray();
			//QueueFromStack queue = new QueueFromStack(); 
			//QueueFromStack queue=new QueueFromStack();
			queue.in(1);  
	        queue.in(2);  
	        queue.in(3);  
	        System.out.println(queue.out()); 
	        System.out.println(queue.out()); 
	        queue.in(4);  
	        System.out.println(queue.out());  
	        System.out.println(queue.out());  
	        queue.in(5);  
	        System.out.println(queue.out()); 
		}

		//使用数组定义一个队列
		static class QueueFromArray {  
		    int[] a = new int[5];  
		    int i = 1; //数组下标
		    //入队
		    public void in(int m){  
		       a[i++] = m;
		    } 
		    //出队
		    public int out(){  
		       int index = 0;  
		       int temp = a[1];  
		       for(int j=1;j<i;j++){  
		         a[j-1] = a[j];  
		         index++;  
		       }  
		       i = index;  
		       return temp;  
		    }  
		} 
		//使用集合定义一个队列
		static class QueueFromList {  
		    List<Integer> list = new ArrayList<Integer>();  
		    int index = 0;  //下标
		    //入队
		    public void in(int n){  
		        list.add(n);  
		        index++;  
		    } 
		    //出队
		    public int out(){  
		       if(!list.isEmpty()){  
		           index--;  
		           return list.remove(0);  
		       }  
		       return -1;  
		    }  
		} 
		//两个堆栈实现一个队列
		static class QueueFromStack {
		    Stack<Integer> stackA = new Stack<Integer>();
		    Stack<Integer> stackB = new Stack<Integer>();
		    //入队
		    public void in(int n) {
		        stackA.push(n);
		    }
		    //出队
		    public int out() {
		        if(stackB.isEmpty()){
		            while (stackA.size > 0) {
		                stackB.push(stackA.pop());
		            }
		        }
		        return stackB.pop();
		    }
		}
	}
