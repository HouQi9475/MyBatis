package com.leo.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.leo.mybatis.po.User;

public class UserDaoImpl implements UserDao {
	// 创建sqlsessionFactory
	private SqlSessionFactory sqlSessionFactory;

	// 通过构造方法注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		// 通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		// 通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		// 通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		// 通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
	}

}
