package com.leo.mybatis.dao;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.leo.mybatis.po.User;

public class UserDaoImplTest {
	// 创建sqlsessionFactory
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建会话工厂,传入配置文件信息
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=userDao.findUserById(1);
        System.out.println(user);
	}

}
