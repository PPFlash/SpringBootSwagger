package com.sfdhb.base.user.service;

import com.sfdhb.base.user.model.User;
import com.sfdhb.controller.user.modle.UserForm;
import com.sfdhb.pub.error.ServiceException;

/**
 * 用户service
 * @author pp
 * @date 2017年9月25日16:05:28
 *
 */
public interface IUserService {
    
	/**
	 * 根据用户id获取用户信息
	 * @param id
	 * @throws ServiceException 
	 */
	User getUser(long id) throws ServiceException;
	
	/**
	 * 保存用户信息
	 * @param user
	 * @throws ServiceException
	 */
	void saveUser(UserForm user) throws ServiceException;
	
	/**
	 * 删除用户信息
	 * @param user
	 * @throws ServiceException
	 */
	void deleteUser(long id) throws ServiceException;
	
}
