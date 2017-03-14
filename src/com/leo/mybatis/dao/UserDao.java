package com.leo.mybatis.dao;

import com.leo.mybatis.po.User;

public interface UserDao {
    //查询根据id
	public User findUserById(int id);
	//添加用户
	public void insertUser(User user);
	//更新用户
	public void updateUser(User user);
	//删除用户
	public void deleteUser(int id);
}
