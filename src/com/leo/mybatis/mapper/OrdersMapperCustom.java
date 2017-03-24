package com.leo.mybatis.mapper;

import java.util.List;

import com.leo.mybatis.po.Orders;
import com.leo.mybatis.po.OrdersCustom;
import com.leo.mybatis.po.User;

public interface OrdersMapperCustom {

	//查询订单关联查询用户信息，映射到ordersCustom类
	public List<OrdersCustom> findUserByOrders();
	//查询订单关联查询用户信息，映射到orders类,用resultMap
	public List<Orders> findUserByOrdersResultMap();
	//查询订单关联查询用户信息及订单详情，映射到orders类,用resultMap
	public List<Orders> findOrderAndOrderdetailByResultMap();
	//查询用户购买的商品详情
	public 	User findUserAndItemsByResultMap();
	//查询订单及用户，延迟加载
	public List<Orders> findOrderAndUserLazyLoading();
	
}
