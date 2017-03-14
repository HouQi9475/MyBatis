package com.leo.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.leo.mybatis.po.User;

public class UserMapperTest {

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
	public void testFindUserByName() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> list=userMapper.findUserByName("小");
		System.out.println(list.size());
	}

}
