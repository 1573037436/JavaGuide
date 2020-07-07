package com.designpattern.composite;
/**
 * 组合模式的使用场景：把部分和整体的关系用树形结构来表示，从而使客户端可以使用统一的方式来处理
 * 部分对象和整体对象
 * 组合模式核心：
 * 1,抽象构件Component角色：定义了叶子和容器的共同点
 * 2,叶子构件Leaf角色:无子节点
 * 3,容器构件Composite角色：有容器特征，可以有子节点
 * @author zhoucheng
 * 应用场景：
 *Junit单元测试框架底层运用的就是组合模式：TestCase(叶子),Test接口(抽象),TestUnit(容器);
 *操作系统的资源管理器
 */
public class Client {

	
	public static void main(String[] args) {
		AbstractFile f2,f3,f4;
		f2=new Imagefile("地球.jpg");
		f3=new Textfile("我的爱好.txt");
		f4=new VideoFile("笑傲江湖.avi");
		Folder f1=new Folder("我的收藏");
		Folder f11=new Folder("我的电影");
		f11.addFile(f4);
		f1.addFile(f2);
		f1.addFile(f3);
		f1.addFile(f11);
		f1.killvirus();
	}

}
