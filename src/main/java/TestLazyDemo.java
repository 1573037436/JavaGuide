import java.io.ObjectStreamException;
import java.io.Serializable;
/**
 * serializable是实现反序列化的接口
 * 
 */

public class TestLazyDemo implements Serializable{
	//私有化构造器
	private TestLazyDemo(){
		//防止反射漏洞
		if(lazydemo!=null){
			throw new RuntimeException();
		}
	}
	//类初始化时，这个对象不被加载（延时加载，用的时候再创建）
	private static TestLazyDemo lazydemo;
	//提供公共的访问对象的方法（方法同步，调用效率低）
	public static synchronized TestLazyDemo getEDeom(){
		if(lazydemo==null){
			lazydemo=new TestLazyDemo();
		}
		return lazydemo;
	}
	//*****************************************
	//防止被序列化
	//反序列化时，如果定义了readResolve（）方法，直接返回此方法指定的对象，而不需在单独创建对象
	private Object readResolve() throws ObjectStreamException{
		return lazydemo;
	}
}
