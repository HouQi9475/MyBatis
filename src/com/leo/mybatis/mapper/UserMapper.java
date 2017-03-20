package com.leo.mybatis.mapper;

import java.util.List;

import com.leo.mybatis.po.User;
import com.leo.mybatis.po.UserCustom;
import com.leo.mybatis.po.UserQueryVo;

public interface UserMapper {
	/**
	 * mapper.java接口中的方法名和mapper.xml中statement的id一致
	 * mapper接口中方法的输入参数类型和mapper.xml中指定的parameterType的类型一致
	 * mapper接口中方法的返回值的类型和mapper.xml中指定的resultType的类型一致
	 */
	// 通过包装类用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);

	//// 通过包装类用户信息综合查询,通过resultMap返回
	public List<UserCustom> findUserListByResultMap(UserQueryVo userQueryVo);

	public User findUserById(int id);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public List<User> findUserByName(String name);
}
