package com.sfdhb.controller.user;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sfdhb.base.user.model.User;
import com.sfdhb.controller.user.modle.UserForm;
import com.sfdhb.pub.error.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 用户操作相关swagger2 Api文档接口
 * @author pp
 * @date 2017年9月22日12:14:18
 *@Api：用在类上，说明该类的作用
 *@ApiOperation：用在方法上，说明方法的作用
 *@ApiImplicitParams：用在方法上包含一组参数说明
 *@ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
 *   |paramType：参数放在哪个地方
 *   |---header-->请求参数的获取：@RequestHeader
 *   |---query-->请求参数的获取：@RequestParam
 *   |---path（用于restful接口）-->请求参数的获取：@PathVariable
 *   |---body（不常用）
 *   |---form（不常用）
 *   |name：参数名
 *   |dataType：参数类型
 *   |required：参数是否必须传
 *   |value：参数的意思
 *   |defaultValue：参数的默认值
 *@ApiResponses：用于表示一组响应
 *@ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
 *   |code：数字，例如400
 *   |message：信息，例如"请求参数没填好"
 *   |response：返回的类模型
 *@ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 *@ApiModelProperty：描述一个model的属性
 *
 */
@Api(value="用户controller",description="用户相关操作",consumes="彭湃")
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public interface UserApi {

	@ApiOperation(value = "获取用户信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="path",dataType="long",name="id",value="用户ID",required=true)
	})
	@ApiResponses({
        @ApiResponse(code = 200, message = "处理成功"),
        @ApiResponse(code = 400, message = "请求参数结构语法错误"),
        @ApiResponse(code = 402, message = "请求参数验证不通过"),
        @ApiResponse(code = 401, message = "未授权[无token、token错误、token过期]"),
        @ApiResponse(code = 406, message = "接口业务相关错误"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	ResponseEntity<User> getUser(@NotEmpty(message = "id不能为空") @PathVariable long id) throws ServiceException;
	
	
	@ApiOperation(value = "保存用户信息", notes = "")
	@ApiResponses({
        @ApiResponse(code = 200, message = "处理成功"),
        @ApiResponse(code = 400, message = "请求参数结构语法错误"),
        @ApiResponse(code = 402, message = "请求参数验证不通过"),
        @ApiResponse(code = 401, message = "未授权[无token、token错误、token过期]"),
        @ApiResponse(code = 406, message = "接口业务相关错误"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
	@RequestMapping(value = "/save",consumes = { "application/json"},method = RequestMethod.POST)
	void saveUser(@ApiParam(value="用户id不能为空",required=true)@Valid @RequestBody UserForm user) throws ServiceException;
	
	
	@ApiOperation(value = "删除用户信息", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="path",dataType="long",name="id",value="用户ID",required=true)
	})
	@ApiResponses({
        @ApiResponse(code = 200, message = "处理成功"),
        @ApiResponse(code = 400, message = "请求参数结构语法错误"),
        @ApiResponse(code = 402, message = "请求参数验证不通过"),
        @ApiResponse(code = 401, message = "未授权[无token、token错误、token过期]"),
        @ApiResponse(code = 406, message = "接口业务相关错误"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	void deleteUser(@NotEmpty(message = "名称不能为空") @PathVariable long id) throws ServiceException;
	
	
	@ApiOperation(value = "修改用户信息", notes = "")
	@ApiResponses({
        @ApiResponse(code = 200, message = "处理成功"),
        @ApiResponse(code = 400, message = "请求参数结构语法错误"),
        @ApiResponse(code = 402, message = "请求参数验证不通过"),
        @ApiResponse(code = 401, message = "未授权[无token、token错误、token过期]"),
        @ApiResponse(code = 406, message = "接口业务相关错误"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
	@RequestMapping(value = "/update",consumes = { "application/json"},method = RequestMethod.PUT)
	ResponseEntity<UserForm> updateUser(@ApiParam(value="要修改的用户信息",required=true)@Valid @RequestBody UserForm user) throws ServiceException;
	
}
