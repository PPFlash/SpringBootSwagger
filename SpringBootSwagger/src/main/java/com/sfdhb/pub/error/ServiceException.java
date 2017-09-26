package com.sfdhb.pub.error;
/**
 * 用于处理项目业务层中所发生的异常
 * @author pp
 * @date 2017年9月22日16:52:11
 *
 */
public class ServiceException extends Exception{

	private static final long serialVersionUID = -5426000021452095905L;
	
	public ServiceException(String string) {
		super(string);
	}

}
