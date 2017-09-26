package com.sfdhb.controller.user.modle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 用户请求数据接收模型 
 * @author pp
 * @date 2017年9月19日11:06:01
 * @Null   被注释的元素必须为 null    
 * @NotNull    被注释的元素必须不为 null    
 * @AssertTrue     被注释的元素必须为 true    
 * @AssertFalse    被注释的元素必须为 false    
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值    
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值    
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值    
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值    
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内    
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内    
 * @Past   被注释的元素必须是一个过去的日期    
 * @Future     被注释的元素必须是一个将来的日期    
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式      
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0    
 * @Email  被注释的元素必须是电子邮箱地址    
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内    
 * @NotEmpty   被注释的字符串的必须非空    
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 */
@ApiModel(description="用户信息模型")
public class UserForm implements Serializable{
	
	private static final long serialVersionUID = -4926987600225678309L;
	
	@NotNull(message = "用户ID不能为空")
	@ApiModelProperty(name="id",value="用户ID",required=true,dataType="long")
	private long id;
	@NotEmpty(message = "用户名不能为空")
	@Pattern(regexp="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",message = "用户名必须为有效手机号")
	@ApiModelProperty(name="userName",value="用户名",required=true,dataType="String")
	private String userName;
	
	@Pattern(regexp="^[a-zA-Z]\\w{5,11}$",message = "密码必须以字母开头,可由字母数字下划线组成,密码长度必须>=6,<=12")
	@NotEmpty(message = "密码不能为空")
	@ApiModelProperty(name="passWord",value="密码",required=true,dataType="String")
	private String passWord;
	
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
    public void setUserName(String userName) {
		this.userName = userName;
	}
    public String getPassWord() {
		return passWord;
	}
    public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
