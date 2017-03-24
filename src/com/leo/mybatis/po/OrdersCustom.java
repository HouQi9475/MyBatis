package com.leo.mybatis.po;
/**
 * OrdersCustom类继承Orders类后OrdersCustom类包括了Orders类的所有字段，
 * 只需要定义用户的信息字段即可。
 * 通过此类映射订单和用户的查询结果
 * @author Administrator
 *
 */
public class OrdersCustom extends Orders {

	//定义用户字段  user.username,user.sex user.address
	private String username;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
