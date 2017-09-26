package com.sfdhb.controller.user;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfdhb.base.user.model.User;
import com.sfdhb.base.user.service.IUserService;
import com.sfdhb.controller.user.modle.UserForm;
import com.sfdhb.pub.error.ServiceException;

import io.swagger.annotations.ApiParam;

@RestController 
public class UserApiController implements UserApi{
	@Autowired
	private IUserService userService;
	public ResponseEntity<User> getUser(@NotEmpty(message = "用户id不能为空") @PathVariable long id) throws ServiceException {//非实体类参数可以直接使用注解
		return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
    }

	public void saveUser(@ApiParam(value="用户信息",required=true)@Valid @RequestBody UserForm user) throws ServiceException{//实体类注解校验使用@Valid
		userService.saveUser(user);
	}

	@Override
	public void deleteUser(@NotEmpty(message = "用户id不能为空") @PathVariable long id) throws ServiceException {
		userService.deleteUser(id);
	}

	@Override
	public ResponseEntity<UserForm> updateUser(@ApiParam(value="要修改的用户信息",required=true) @RequestBody UserForm user) throws ServiceException {
		if(user.getPassWord().equals("123")){
			throw new ServiceException("密码错误!");
		}
		return new ResponseEntity<UserForm>(user,HttpStatus.OK);
	}
	
}