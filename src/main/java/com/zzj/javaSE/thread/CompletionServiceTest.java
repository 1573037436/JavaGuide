package com.zzj.javaSE.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。——实现Runnable接口
 * submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。——实现Callable接口
 */
public class CompletionServiceTest {

	public static void main(String[] args) throws Exception {

        CompletionServiceTest cst = new CompletionServiceTest();
        //cst.count1();
        System.out.println("\n-------------------------------");
        long startTime=System.currentTimeMillis();
        cst.count2();
        long endTime=System.currentTimeMillis();
        System.out.print("\n总耗时："+(endTime-startTime)/1000+"S");
        System.out.println("\n执行主线程:"+Runtime.getRuntime().availableProcessors());
    }

    /**
     * Executors结合BlockingQueue保存每个Future，按先进先出的顺序得到线程的结果
     * BlockingQueue是先进先出的列队。为什么说是阻塞（Blocking）的呢？
     * 是因为 BlockingQueue 支持当获取队列元素但是队列为空时，会阻塞等待队列中有元素再返回；
     * 也支持添加元素时，如果队列已满，那么等到队列可以放入新元素时再放入。
     * 存在的问题：对于本例中的线程3，由于比较耗时，将导致获取结果被阻塞，等待线程进入队列才可以取出。
     * 
     * @throws Exception
     */
    public void count1() throws Exception {
    	//线程池
        ExecutorService exec = Executors.newCachedThreadPool();  
        //阻塞列队
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingQueue<Future<Integer>>();  
        System.out.println("阻塞列队获取结果....................");
        for (int i = 0; i < 10; i++) {
        	//如果不需要异步返回结果，请不要用submit方法,异常日志在submit方法中给catch住，没有打印出来，而被捕获的异常，
        	//被包装在返回的结果类FutureJoinTask中，并没有再次抛出。
            Future<Integer> future = exec.submit(getTask(i));
            queue.add(future);  //先进先出排序
        }
        //确保全部Future进入队列，没有这个睡眠队列中有值就会被获取
        Thread.sleep(5000);  
        System.out.println();
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.print("取出："+queue.take().get()+"  ");  //按进去的顺序取出
        }
        exec.shutdown();
    }

    /**
     * 使用CompletionService(完成服务)异步非阻塞获取线程执行的结果，结果按照完成先后顺序排序
     * CompletionService整合了Executor和BlockingQueue的功能，
     * 不同之处是executor.execute(new QueueingFuture(f));
     * 而QueueingFuture实现了FutureTask，并且重写了done()方法。
     * 该方法是异步计算完成后调用的回调函数，在该方法里将完成的task放入BlockingQueue队列。
     * 不需要等待线程中某个耗时操作，会按照线程完成时间返回结果。
     * 
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public void count2() throws InterruptedException, ExecutionException {
    	
        //ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newFixedThreadPool(100);
        CompletionService<Integer> execcomp = new ExecutorCompletionService<Integer>(exec);
        System.out.println("CompletionService获取结果.........................");
        for (int i = 0; i < 1000000; i++) {
            execcomp.submit(getTask(i));  //已经按线程完成顺序排序进入队列
        }
        //Thread.sleep(5000);
        //System.out.println(" ");
        for (int i = 0; i < 1000000; i++) {
            // take()阻塞等待获取队列中的结果
            Future<Integer> future = execcomp.take();
            System.out.print("取出："+future.get()+"  ");
        }
        exec.shutdown();
    }

    /**
     * 得到一个任务
     * 
     * @return
     */
    public Callable<Integer> getTask(int i) {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
            	//Thread.sleep(10000);
                /*if(i==3){
                    Thread.sleep(i*1000);  //让第三个线程睡眠3秒
                }*/
                System.out.print("\n线程名:"+Thread.currentThread().getName()+"【"+i + "】");
                return i;
            }
        };
        return task;
    }

}
