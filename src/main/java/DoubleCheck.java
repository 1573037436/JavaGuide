/**
 * 双重检测锁模式
 * 问题：由于编译器优化和JVM底层内部模型等问题
 * 偶尔会出问题，不建议使用
 * @author zhoucheng
 *
 */
public class DoubleCheck {
	//私有化构造器
	private DoubleCheck(){}
	//类初始化时，立即加载这个对象（没有延时加载的优势），加载类时，天然的是线程安全的
	private static DoubleCheck ehanshi=null;
	//这个模式将同步内容放到if内部，提高了执行效率，不必每次获取对象时都进行同步，
	//只有在第一次才进行同步，创建以后就没必要了
	public static DoubleCheck getEDeom(){
		if(ehanshi==null){
			DoubleCheck dc;
			synchronized(DoubleCheck.class){
				dc=ehanshi;
				if(dc==null){
					synchronized(DoubleCheck.class){
						if(dc==null){
							dc=new DoubleCheck();
						}
					}
					ehanshi=dc;
				}
			}
		}
		return ehanshi;
	}
}
