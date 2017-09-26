package com.sfdhb.base.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfdhb.base.user.dao.UserDao;
import com.sfdhb.base.user.model.User;
import com.sfdhb.controller.user.modle.UserForm;
import com.sfdhb.pub.error.ServiceException;
/**
 * 注意: 如果类上或方法上启用了@Transactional事务注解,在方法内抛出的异常和try catch捕捉的异常将有 TransactionSystemException 
 *      代为包装处理.
 */
@Service 
@Transactional
public class UserService implements IUserService{
    @Autowired
    private UserDao userDao;
	@Override
	public User getUser(long id) throws ServiceException {
		User user = userDao.findOne(id);
		if(user==null){
			throw new ServiceException("用户不存在!");
		}
		return user;
	}
	@Override
	public void saveUser(UserForm user) throws ServiceException {
		User u = new User();
		u.setPassWord(user.getPassWord());
		u.setUserName(user.getUserName());
		userDao.save(u);
	}
	@Override
	public void deleteUser(long id) throws ServiceException {
	  try {
		    User u = new User();
			u.setPassWord("123");
			u.setUserName("123");
			userDao.save(u);
		    userDao.delete(id);
	  } catch (EmptyResultDataAccessException e) {
	     throw new ServiceException("要删除的用户不存在!");
	  }
	}
}
