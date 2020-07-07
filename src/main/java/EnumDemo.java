/**
 *枚举本身就是单例模式，由JVM从根本上提供保障，避免通过反射和反序列化的漏洞
 * 缺点：无延时加载
 * @author zhoucheng
 *
 */
public enum EnumDemo {
	//定义一个枚举的元素，它就代表enumdeom的一个实例
	instance;
	//可以有自己的功能（方法）
}
