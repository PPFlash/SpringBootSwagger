package com.sfdhb.pub.error;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理:
 *  用于处理程序中的各种异常,以及异常发生后返回的数据.
 * @author pp
 * @date 2017年9月20日16:33:29
 *
 */
@ControllerAdvice
public class UnifiedErrorHandle {
	/**
	 * 默认异常处理
	 * @param req
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Void> defaultErrorHandler(HttpServletRequest req,HttpServletResponse response,Exception e) throws Exception {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
	/**
	 * 系统事务全局异常处理
	 * @param req
	 * @param response
	 * @param e
	 * @return
	 * @throws TransactionSystemException
	 */
	@ResponseBody
	@ExceptionHandler(value = TransactionSystemException.class)
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest req,HttpServletResponse response,TransactionSystemException e) throws Exception {
		if(e.getApplicationException() instanceof ServiceException){
			ServiceException exception = (ServiceException) e.getApplicationException();
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
	/**
	 * 请求参数验证全局异常处理
	 * @param req
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> parameterVerificationErrorHandler(HttpServletRequest req,HttpServletResponse response,MethodArgumentNotValidException e) throws Exception {
		StringBuffer str = new StringBuffer();
		for (ObjectError error : e.getBindingResult().getAllErrors()) {
			FieldError fidldError = (FieldError) error;
			str.append("[").append(fidldError.getField()).append(":").append(fidldError.getDefaultMessage()).append("]").append("\r\n");
		}
		return new ResponseEntity<String>(str.toString(),HttpStatus.PAYMENT_REQUIRED);
    }
	
	/**
	 * 请求参数结构全局异常处理
	 * @param req
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<String> parameterStructureErrorHandler(HttpServletRequest req,HttpServletResponse response,HttpMessageNotReadableException e) throws Exception {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	/**
	 * 接口业务相关全局异常处理
	 * @param req
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<String> userErrorHandler(HttpServletRequest req,HttpServletResponse response,ServiceException e) throws Exception {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
}
