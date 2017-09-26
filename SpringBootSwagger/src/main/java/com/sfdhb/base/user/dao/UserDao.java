package com.sfdhb.base.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sfdhb.base.user.model.User;

/**
 * 用户dao
 * @author pp
 * @date 2017年9月25日15:58:51
 *
 */
public interface UserDao extends JpaRepository<User, Long>{
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	public User findById(String id); 
}
