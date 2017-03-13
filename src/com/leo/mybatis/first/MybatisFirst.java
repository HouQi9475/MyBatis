package com.leo.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.leo.mybatis.po.User;

/*
 * 根据id查询用户信息
 */
public class MybatisFirst {

	@Test
	public void findByUserIdTest() throws IOException{
		//创建会话工厂,传入配置文件信息
		String resource="SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlsession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过selsession操作数据库
		//statement:映射文件中的statementID，等于命名空间+"."+statement的id
		//parameter:指定和映射文件中所匹配的parametertype类型一致的参数
		//结果与映射文件中指定的resulttype对象类型一致
		User user=sqlSession.selectOne("test.findUserById", 1);
		
		//释放资源
		sqlSession.close();
	}
	@Test
	public void findByUserName(){
		//创建会话工厂,传入配置文件信息
				String resource="SqlMapConfig.xml";
				//得到配置文件流
				InputStream inputStream;
				try {
					inputStream = Resources.getResourceAsStream(resource);
					SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
					//通过工厂得到sqlsession
					SqlSession sqlSession=sqlSessionFactory.openSession();
					
					//通过selsession操作数据库
					//statement:映射文件中的statementID，等于命名空间+"."+statement的id
					//parameter:指定和映射文件中所匹配的parametertype类型一致的参数
					//结果与映射文件中指定的resulttype对象类型一致
					List<User> users=sqlSession.selectList("test.findUserByName", "小明");
					for (User user : users) {
						System.out.println(user);
					}
					sqlSession.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
	}
	@Test
	public void insertUser(){
		//创建会话工厂,传入配置文件信息
		String resource="SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到sqlsession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//通过selsession操作数据库
			//statement:映射文件中的statementID，等于命名空间+"."+statement的id
			//parameter:指定和映射文件中所匹配的parametertype类型一致的参数
			//结果与映射文件中指定的resulttype对象类型一致
			//插入用户对象
			User user=new User();
			user.setUsername("ramon");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("山西介休");
			sqlSession.insert("test.insertUser", user);
			//执行提交事务
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void deleteUser(){
		//创建会话工厂,传入配置文件信息
		String resource="SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到sqlsession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//通过selsession操作数据库
			//statement:映射文件中的statementID，等于命名空间+"."+statement的id
			//parameter:指定和映射文件中所匹配的parametertype类型一致的参数
			//结果与映射文件中指定的resulttype对象类型一致
			//传入id删除用户
			sqlSession.delete("test.deleteUser", 34);
			//执行提交事务
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateUser(){
		//创建会话工厂,传入配置文件信息
		String resource="SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到sqlsession
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//通过selsession操作数据库
			//statement:映射文件中的statementID，等于命名空间+"."+statement的id
			//parameter:指定和映射文件中所匹配的parametertype类型一致的参数
			//结果与映射文件中指定的resulttype对象类型一致
			//根据用户id更新
			User user=new User();
			user.setId(33);
			user.setUsername("hou");
			sqlSession.update("test.updateUser", user);
			//执行提交事务
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

