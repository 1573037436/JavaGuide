
public class EDeom {
	//私有化构造器
	private EDeom(){}
	//类初始化时，立即加载这个对象（没有延时加载的优势），加载类时，天然的是线程安全的
	private static EDeom ehanshi=new EDeom();
	//提供公共的访问对象的方法（方法没有同步，调用效率高）
	public static EDeom getEDeom(){
		return ehanshi;
	}
}
