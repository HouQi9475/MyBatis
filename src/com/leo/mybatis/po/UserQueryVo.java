package com.leo.mybatis.po;

import java.util.List;

/**
 * 通过包装类对象传递参数 开发中通过pojo传递查询条件 ，查询条件是综合的查询条件，
 * 不仅包括用户查询条件还包括其它的查询条件（比如将用户购买商品信息也作为查询条件）， 这时可以使用包装对象传递输入参数。
 * 
 * @author Administrator
 *
 */
public class UserQueryVo {
	// 定义包装对象将查询条件(pojo)以类组合的方式包装起来。
	//定义传入的多个ID，用List集合
	private List<Integer> ids;
	// 自定义用户扩展类
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
