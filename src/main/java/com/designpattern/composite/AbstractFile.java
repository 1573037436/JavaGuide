package com.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

//抽象组件
public interface AbstractFile {
	void killvirus();//杀毒 
}
class Imagefile implements AbstractFile{
	private String name;
	@Override
	public void killvirus() {
		System.out.println("图像文件"+name+"被查杀");
	}
	public Imagefile(String name) {
		super();
		this.name = name;
	}
	
}
class Textfile implements AbstractFile{
	private String name;
	@Override
	public void killvirus() {
		System.out.println("文本文件"+name+"被查杀");
	}
	public Textfile(String name) {
		super();
		this.name = name;
	}
	
}
class VideoFile implements AbstractFile{
	private String name;
	@Override
	public void killvirus() {
		System.out.println("影视文件"+name+"被查杀");
	}
	public VideoFile(String name) {
		super();
		this.name = name;
	}
	
}
//文件夹（容器组件）
class Folder implements AbstractFile{
	private String name;
	//存放容器下的子节点
	private List<AbstractFile> list=new ArrayList<AbstractFile>();
	@Override
	public void killvirus() {
		System.out.println("文件夹"+name+"被查杀");
		//递归调用（文件夹中存在文件夹）
		for (AbstractFile file : list) {
			file.killvirus();
		}
	}
	public Folder(String name) {
		super();
		this.name = name;
	}
	public void addFile(AbstractFile file){
		list.add(file);
	}
	public void removeFile(AbstractFile file){
		list.remove(file);
	}
	public AbstractFile getFile(int index){
		return list.get(index);
	}
}