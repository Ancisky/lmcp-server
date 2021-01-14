package com.kglab.lmcp.global.handle;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.entity.vo.ResultVo;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理类
 * @author shuchao
 * @date   2019年2月3日
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	/**
	 * 异常状态码
	 */
	public static final int DEFAULT = StatusCode.SYSTEM_ERROR;
	
	/**
	 * 捕获所有抛出的Exception，进行下面处理
	 * @param request
	 * @param Exception
	 * @return
	 */
	@ExceptionHandler(value=Exception.class) 
	@ResponseBody
	private ResultVo exceptionHandler(HttpServletRequest request, Exception e) {
		ResultVo rv = new ResultVo(DEFAULT,e.getMessage());
		if(! (e instanceof ResultVoMessage))
			log.error("全局拦截异常", e);
		return rv;
	}
	
	
	/**
	 *自定义事务异常拦截，用于响应结果
	 * @param e
	 * @return com.kglab.lmcp.entity.vo.ResultVo
	 * @author sc
	 * @date 2021/1/12
	 */
	@ExceptionHandler(value= ResultVoMessage.class)
	@ResponseBody
	private ResultVo exceptionHandler(ResultVoMessage e) {
		ResultVo rv = ResultVo.builder()
				.no(e.getErrorNo())
				.msg(e.getErrorMsg())
				.data(e.getData()).build();
		return rv;
	}

	/**
	 * 请求参数验证失败异常，ConstraintViolationException
	 * @param e
	 * @return com.kglab.lmcp.entity.vo.ResultVo
	 * @author sc
	 * @date 2021/1/12
	 */
	@ExceptionHandler(value= ConstraintViolationException.class)
	@ResponseBody
	private ResultVo exceptionHandler(ConstraintViolationException e) {
		Set <ConstraintViolation<?>> violations = e.getConstraintViolations();
		ResultVo rv = ResultVo.builder()
				.no(StatusCode.REBUT)
				.msg(violations.iterator().next().getMessage())
				.build();
		return rv;
	}
}
