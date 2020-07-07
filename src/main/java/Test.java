import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;


/**
 * 用反射和反序列化破解以上几种模式（不包含枚举）
 * 
 */
public class Test {

	public static void main(String[] args) throws Exception {
		TestLazyDemo tld=TestLazyDemo.getEDeom();
		TestLazyDemo tld1=TestLazyDemo.getEDeom();
		
		System.out.println(tld);
		System.out.println(tld1);
		/*//通过反射获得私有化构造器	
		Class<TestLazyDemo> clazz=(Class<TestLazyDemo>)Class.forName("TestLazyDemo");
		Constructor<TestLazyDemo> c=clazz.getDeclaredConstructor(null);
		//跳过访问检查
		c.setAccessible(true);
		//通过构造器创建对象
		TestLazyDemo t1= c.newInstance();
		TestLazyDemo t2= c.newInstance();
		
		
		System.out.println(t1);
		System.out.println(t2);
		*/
			
			//通过反序列化方式构造多个对象
			//写出数据
			FileOutputStream fo=new FileOutputStream("D:/a.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fo);
			oos.writeObject(tld);
			oos.close();
			fo.close();
			
			//写入数据
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:/a.txt"));
			TestLazyDemo t3=(TestLazyDemo)ois.readObject();
			ois.close();
			
			System.out.println(t3);
			
		}

	}