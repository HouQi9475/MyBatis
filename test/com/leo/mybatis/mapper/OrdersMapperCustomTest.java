package com.leo.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.leo.mybatis.po.Orders;
import com.leo.mybatis.po.OrdersCustom;
import com.leo.mybatis.po.User;
import com.leo.mybatis.po.UserQueryVo;

public class OrdersMapperCustomTest {
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
	public void test() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list=ordersMapperCustom.findUserByOrders();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void findUserByOrdersResultMapTest(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list=ordersMapperCustom.findUserByOrdersResultMap();
		System.out.println(list);
		sqlSession.close();	
	}
	@Test
	public void testFindOrderAndOrderdetailByResultMap(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list=ordersMapperCustom.findOrderAndOrderdetailByResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindUserAndItemsByResultMap(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		User user=ordersMapperCustom.findUserAndItemsByResultMap();
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testFindOrderAndUserLazyLoading(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> orders=ordersMapperCustom.findOrderAndUserLazyLoading();
		System.out.println(orders);
		//开始延迟加载，通过orders.getUser()方法进行加载
		for(Orders order:orders){
			User user=order.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}

}
