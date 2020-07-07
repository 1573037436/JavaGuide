

import java.util.concurrent.CountDownLatch;

public class TestSpeed {

	
	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		int threadnum=10;
		//
		final CountDownLatch countdownlatch=new CountDownLatch(threadnum);
		for (int i = 0; i < threadnum; i++) {
			new Thread(new Runnable(){

				@Override
				public void run() {
					for (int j = 0; j < 100000; j++) {
						//
						Object edemo1=EDeom.getEDeom();
						//Object edemo2=LazyDemo.getEDeom();//
						//Object edemo3=DoubleCheck.getEDeom();
						//Object edemo4=StaticDemo.getstaticdemo();
						//
						//Object edemo5=EnumDemo.instance;						
					}
					//
					countdownlatch.countDown();
				}}).start();			
		}
		countdownlatch.await();//
		long end=System.currentTimeMillis();
		System.out.println("总共耗时"+(end-start));
	}

}
