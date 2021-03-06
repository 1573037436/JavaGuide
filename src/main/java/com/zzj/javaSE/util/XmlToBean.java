package com.zzj.javaSE.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.zzj.javaSE.model.Student;
import com.zzj.javaSE.model.StudentList;
public class XmlToBean {
    /**
     * xml文件配置转换为对象
     * @param xmlPath  xml文件路径
     * @param load    java对象.Class
     * @return    java对象
     * @throws JAXBException    
     * @throws IOException
     */
    public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(load);  
        Unmarshaller unmarshaller = context.createUnmarshaller(); 
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }
    
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlPath =  "D:/testConfig.xml";
        Object object = XmlToBean.xmlToBean(xmlPath,StudentList.class);
        StudentList students = (StudentList)object;
        List<Student> studentList = students.getStudents();
        
        for(int i=0;i<studentList.size();i++){
            System.out.println(studentList.get(i).getName());
            System.out.println(studentList.get(i).getSex());
            System.out.println(studentList.get(i).getNumber());
            System.out.println(studentList.get(i).getClassName());
            for(String str :studentList.get(i).getHobby()){
                System.out.print(str+" ");
            }
            System.out.println("-------------");
        }
    }
}
