package com.zzj.javaSE.xml.test;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.zzj.javaSE.xml.dom4j.Dom4jDemo;
import com.zzj.javaSE.xml.jdom.JDomDemo;
import com.zzj.javaSE.xml.sax.DomDemo1;
import com.zzj.javaSE.xml.sax.XmlParser;


public class Test {
	@org.junit.Test
	public void testDom(){
//		DomDemo demo=new DomDemo();
//		demo.init();
//		demo.createXml("D:\\Java\\XmlDemo\\src\\employee.xml");
		DomDemo1 demo=new DomDemo1();  
		demo.createXml(); 
		}
	@org.junit.Test
	public void testParseDom(){
//		DomDemo demo=new DomDemo();		
//		demo.parserXml("D:\\Java\\XmlDemo\\src\\employee.xml");
		XmlParser parser = new XmlParser();  
        try {
			parser.parserXMLFile("src\\com\\zzj\\javaSE\\xml\\test\\cities.xml");
		} catch (SAXException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	@org.junit.Test
	public void testJDom(){
		JDomDemo demo=new JDomDemo();
		demo.createXml("src\\com\\zzj\\javaSE\\xml\\test\\employee2.xml");
		}
	
	@org.junit.Test
	public void testParseJDom(){
		Dom4jDemo demo=new Dom4jDemo();
		demo.parserXml("src\\com\\zzj\\javaSE\\xml\\test\\employee.xml");
	}
	@org.junit.Test
	public void testDom4j(){
		Dom4jDemo demo=new Dom4jDemo();
		demo.createXml("src\\com\\zzj\\javaSE\\xml\\test\\employee1.xml");
		}
	
	@org.junit.Test
	public void testParseDom4j(){
		Dom4jDemo demo=new Dom4jDemo();
		demo.parserXml("src\\com\\zzj\\javaSE\\xml\\test\\employee.xml");
	}
}
