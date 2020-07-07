package com.zzj.javaSE.xml.jdom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.zzj.javaSE.xml.dom.Xmldocument;

/**
 * 
 * 为减少DOM、SAX的编码量，出现了JDOM；优点：20-80原则，极大减少了代码量。
 * 使用场合：要实现的功能简单，如解析、创建等，
 * 但在底层，JDOM还是使用SAX（最常用）、DOM、Xanan文档。
 * （1）JDOM解析XML文档所使用到的jar包：jdom.jar
 *
 */
public class JDomDemo implements Xmldocument {
	 public void createXml(String fileName) {  
	        Document document;  
	        Element root;
	        //创建一个根节点
	        root = new Element("employees");  
	        document = new Document(root);  
	        Element employee = new Element("employee");
	        //将employee节点添加到根节点root下
	        root.addContent(employee);  
	        Element name = new Element("name");
	        //给节点设定一个值
	        name.setText("ddvip");  
	        employee.addContent(name);  
	        Element sex = new Element("sex");  
	        sex.setText("m");  
	        employee.addContent(sex);  
	        Element age = new Element("age");  
	        age.setText("23");  
	        employee.addContent(age);  
	        XMLOutputter XMLOut = new XMLOutputter();  
	        try { 
	        	//以文件的形式输出xml到硬盘上
	            XMLOut.output(document, new FileOutputStream(fileName));  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public void parserXml(String fileName) {  
	        SAXBuilder builder = new SAXBuilder(false);  
	        try { 
	        	//获得document的实例
	            Document document = builder.build(fileName);
	            //获取根节点
	            Element employees = document.getRootElement(); 
	            //获取子节点的集合
	            List employeeList = employees.getChildren();  
	            // 遍历集合
	            for (int i = 0; i < employeeList.size(); i++) { 
	            	//获取employees节点下面的所有子节点employee 
	                Element employee = (Element) employeeList.get(i);  
	              //获取employee节点下的子节点的集合
	                List employeeInfo = employee.getChildren();  
	                // 遍历集合获取employee节点下面的所有子节点  
	                for(int j = 0; j < employeeInfo.size(); j++) {  
	                    Element info = (Element)employeeInfo.get(j);
	                    //打印出节点的名字和值
	                    System.out.println(info.getName() + ":" + info.getValue());  
	                }  
	            }  
	        } catch (JDOMException  e) {  
	            System.out.println(e.getMessage());  
	        } catch (IOException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
}
