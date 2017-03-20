package com.leo.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.leo.mybatis.po.User;
import com.leo.mybatis.po.UserCustom;
import com.leo.mybatis.po.UserQueryVo;

public class UserMapperTest {

	// 创建sqlsessionFactory
	private SqlSessionFactory sqlSessionFactory;
	// 创建UserQueryVo对象
	UserQueryVo queryVo = new UserQueryVo();

	@Before
	public void setUp() throws Exception {

		// 创建会话工厂,传入配置文件信息
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByName("小");
		System.out.println(list.size());
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		UserCustom custom=new UserCustom();
		//创建ids对象
		List<Integer> ids=new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		//将ids注入queryVo
		queryVo.setIds(ids);
		//custom.setSex("1");
		custom.setUsername("张");
		queryVo.setUserCustom(custom);
		List<UserCustom> list=(List<UserCustom>) userMapper.findUserList(queryVo);
		System.out.println(list.size());
	}
	@Test
	public void testFindUserListByResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		UserCustom custom=new UserCustom();
		//custom.setSex("1");
		custom.setUsername("小明");
		queryVo.setUserCustom(custom);
		List<UserCustom> list=(List<UserCustom>) userMapper.findUserListByResultMap(queryVo);
		System.out.println(list.size());
	}
}
