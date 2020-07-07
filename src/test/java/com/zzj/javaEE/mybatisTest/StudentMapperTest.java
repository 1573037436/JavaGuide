package com.zzj.javaEE.mybatisTest;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.zzj.javaSE.model.Student;
import com.zzj.javaSE.object.clone.RandomStringUtil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
/**
 * 基础crud功能
 * @author zzj
 * @date 2020年1月15日
 */
public class StudentMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
 
    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Test
    public void testSelectList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Student> students = sqlSession.selectList("selectAll");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("selectAll result "+students.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Test
    public void addStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int studentNum=new Random().nextInt();
            String sex=null;
            Random random=new Random(System.currentTimeMillis());
			if(random.nextBoolean()){
				sex="女";
			}else {
				sex="男";
			}
            Student student=new Student(RandomStringUtil.getChineseName(), sex, studentNum, "武汉大学"+studentNum,new Date());
            int num = sqlSession.insert("addStudent", student);
            sqlSession.commit();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void findById() {
        SqlSession sqlSession = null;
        Student student=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            student = sqlSession.selectOne("findById", 1);
            System.out.println("findById result "+student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Test
    public void updateStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 56);
            if (student!=null) {
                student.setClassName("updateStudent ClassName");
                int updateNum = sqlSession.update("updateStudent", student);
                sqlSession.commit();
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void deleteStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int updateNum = sqlSession.delete("deleteStudent", 1);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void findStudentWithNameLike(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 5);
            if(student!=null){
            	  student.setName(null);
                  List<Student> students= sqlSession.selectList("findStudentWithNameLike", student);
                  sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void findStudentChoose(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 69);
            student.setName(null);//走when条件
            student.setCreateTime(null);//createTime为null走otherwise条件
            List<Student> students= sqlSession.selectList("findStudentChoose", student);
            System.out.println(students.stream().findFirst().toString());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void findActiveAnd(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 69);
            //student.setCreateTime(null);//createTime不为空，执行的sql为：SELECT * FROM student WHERE 1=1 AND name like ? 
            List<Student> students= sqlSession.selectList("findActiveAnd", student);
            System.out.println(students.stream().findFirst().toString());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void updateStudentIfNecessary(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 69);
            student.setName("动态更新名字");
            student.setClassName("动态更新班级名字");
            //student.setCreateTime(null);//createTime不为空，执行的sql为：SELECT * FROM student WHERE 1=1 AND name like ? 
            int num= sqlSession.update("updateStudentIfNecessary", student);
            System.out.println(num);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void selectStudentNameIn(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<String> names=new ArrayList<String>();
            names.add("皇甫回");
            names.add("巩败");
            names.add("仲孙崩");
            //SELECT * FROM Student WHERE name in ( ? , ? , ? ) 
            List<Student> students= sqlSession.selectList("selectStudentNameIn", names);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    //测试传入的参数是map
    @Test
    public void addStudentMapParam(){
    	Map<String, Map<String, Object>> params=new HashMap<>();
    	Map<String, Object> map=new HashMap<>();
    	map.put("name", "testMapParam");
    	map.put("sex", "女");
    	map.put("className", "testMapParam");
    	map.put("number", 11);
    	map.put("createTime", new Date());
    	params.put("keys", map);
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("addStudentMapParam", params);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    	
    	
    }
    //构建sql语句用于crud
    @Test
    public void selectStudentSql(){
    	SqlSession sqlSession = null;
    	new SQL(){{
    	SELECT("S.ID, S.NAME, S.SEX, S.CLASSNAME, S.CREATETIME");
        FROM("Student S");
        }}.toString();
        sqlSession = sqlSessionFactory.openSession();
    }
}