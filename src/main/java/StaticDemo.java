/**
 * 静态内部类实现单例模式
 * 这种方式：线程安全，调用效率高，延时加载
 * @author zhoucheng
 *
 */
public class StaticDemo {
	//私有化构造器
	private StaticDemo(){}
	//提供静态内部类
	private static class GetEDeom{
		private static final StaticDemo staticdemo=new StaticDemo();		
	}
	//提供公共的方法，用以获取对象
	public static StaticDemo getstaticdemo(){
		return GetEDeom.staticdemo;
	}
}
