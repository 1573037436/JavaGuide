package com.zzj.javaSE.xml.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * 为 XML 文档的已解析版本定义了一组接口。解析器读入整个文档，
 * 然后构建一个驻留内存的树结构，然后代码就可以使用 DOM 接口来操作这个树结构。
 * 优点：整个文档树在内存中，便于操作；支持删除、修改、重新排列等多种功能；
 * 缺点：将整个文档调入内存（包括无用的节点），浪费时间和空间；
 * 使用场合：一旦解析了文档还需多次访问这些数据；硬件资源充足（内存、CPU）。 
 * 
 *
 */
public class DomDemo implements Xmldocument {
	private Document document;
	//得到document实例
	public void init() {  
        try {  
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = factory.newDocumentBuilder();  
            this.document = builder.newDocument();  
        } catch(ParserConfigurationException  e) {  
            System.out.println(e.getMessage());  
        }  
    }  
	public void createXml(String fileName) {
		//创建一个根节点
		Element root=this.document.createElement("employees");
		//将根节点添加到xml文档中
		this.document.appendChild(root);
		//循环添加多个节点
		for (int i = 0; i < 3; i++) {
			Element employee=this.document.createElement("employee");
			//分别创建name,age,sex节点并赋值,然后将name,age,sex三个节点添加到employee节点下
			Element name=this.document.createElement("name");
			name.appendChild(this.document.createTextNode("张三"));
			Element age=this.document.createElement("age");
			age.appendChild(this.document.createTextNode("20"));
			Element sex=this.document.createElement("sex");
			sex.appendChild(this.document.createTextNode("男"));
			employee.appendChild(name);
			employee.appendChild(age);
			employee.appendChild(sex);
			//最后将employee添加到root节点下
			root.appendChild(employee);
		}
		
		//将xml文件写到对应的文件中		
		TransformerFactory tf = TransformerFactory.newInstance();   
        try {   
            Transformer transformer = tf.newTransformer();   
            DOMSource source = new DOMSource(document);   
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");   
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //写入文件
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));    
            StreamResult result = new StreamResult(pw);   
            transformer.transform(source, result);   
            System.out.println("生成XML文件成功!");   
        } catch (TransformerConfigurationException e) {   
            System.out.println(e.getMessage());   
        } catch (IllegalArgumentException e) {   
            System.out.println(e.getMessage());   
        } catch (FileNotFoundException e) {   
            System.out.println(e.getMessage());   
        } catch (TransformerException e) {   
            System.out.println(e.getMessage());   
        }   
	}

	
	public void parserXml(String fileName) {
		try {  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document document = db.parse(fileName); // 读取xml文件
            //得到xml根节点(employees)的集合
            NodeList employees = document.getChildNodes();         
            //遍历根节点
            for (int i = 0; i < employees.getLength(); i++) {  
                //Node employee = employees.item(i); 
            	//得到xml节点(employee)的集合
                NodeList employeeInfo =employees.item(i).getChildNodes();  
                for (int j = 0; j < employeeInfo.getLength(); j++) {  
                    //Node node = employeeInfo.item(j);
                	//得到xml节点(name,age,sex)的集合
                    NodeList employeeMeta =employeeInfo.item(j).getChildNodes();  
                    for (int k = 0; k < employeeMeta.getLength(); k++) {  
                        System.out.println(employeeMeta.item(k).getNodeName()+":"+employeeMeta.item(k).getTextContent());                       
                    }  
                } 
               
            }  
        
            System.out.println("解析完毕");  
        } catch (FileNotFoundException e) {  
            System.out.println(e.getMessage());  
        } catch (ParserConfigurationException e) {  
            System.out.println(e.getMessage());  
        } catch (SAXException e) {  
            System.out.println(e.getMessage());  
        } catch (IOException e) {  
            System.out.println(e.getMessage());  
        }  
    }   
}
