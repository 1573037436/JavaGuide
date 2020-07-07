package com.zzj.javaSE.queue;

import java.util.Arrays;

/*
 * 用数组来实现一个栈
 * 栈：后进先出
 * 主要有push pop peek isEmpty 
 * peek 负责获取栈顶元素 在数组的实现中 peek负责获取最新存放在数组中的元素 stack[size-1]
 * 这样在pop取出元素的时候直接获取peek()的值就好
 * push往数组中存放元素的时候 直接将size+1 并且将这个元素放在stack[size++]的位置
 * 最后要注意数组的容量 在向数组中放元素的时候不要超过初始化的定义
 */
public class Stack<E> {
        int size;//数组中存储元素的个数
	    private Object[] stack;
	    public Stack(){
	        stack=new Object[10];
	    }
	    public Boolean isEmpty(){
	        return size==0;
	    }

        /**
         * 获取栈顶元素
         * @return
         */
        public E peek(){
            if(isEmpty()){
                return null;
            }
            return (E) stack[size-1];
        }
        /**
         * 添加元素
         * @param item
         * @return
         */
        public E push(E item){
        	ensureCapacity(size+1);//往数组中添加元素的时候 先进行容量检测 如果已经放满了 那么就再+10个容量
            stack[size++]=item;
            return item;
        }

        /**
         * 弹出栈顶元素(删除栈顶元素，并将该元素返回)
         * @return
         */
        public E pop(){
          E e= peek();
          stack[size-1]=null;
          size--;
          return e; 
        }
        /**
         * 容量检测
         * @param size
         */
        public void ensureCapacity(int size){
            int len =stack.length;
            if (len>size){
                int newLen=10;
                stack=Arrays.copyOf(stack,newLen);
            }

        }
        public static void main(String[] args){
            Stack<Integer> s=new Stack<>();
            s.push(56);
            s.push(6785);
            s.push(342);
            System.out.println("弹出栈顶元素前，栈中元素的个数"+s.size);
            System.out.println("栈顶元素为"+s.pop());//删除栈顶元素，并返回该元素-> 打印 342
            System.out.println("栈顶元素为"+s.pop());//删除栈顶元素，并返回该元素->打印 6785
            System.out.println("栈顶元素为"+s.peek());//取出栈顶元素，并不删除元素,打印 56
            System.out.println("弹出栈顶元素后，栈中元素的个数"+s.size);
        }
}
