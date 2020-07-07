
public class LazyDemo {
	//私有化构造器
	private LazyDemo(){}
	//类初始化时，这个对象不被加载（延时加载，用的时候再创建）
	private static LazyDemo lazydemo;
	//提供公共的访问对象的方法（方法同步，调用效率低）
	public static synchronized LazyDemo getEDeom(){
		if(lazydemo==null){
			lazydemo=new LazyDemo();
		}
		return lazydemo;
	}
}
