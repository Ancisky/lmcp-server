package com.kglab.lmcp.controller;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.entity.vo.ResultVo;
import com.kglab.lmcp.global.handle.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
/**
 * TODO 基础control类，继承它集成部分重叠方法，便于调用
 * @author sc
 * @date 2021/1/14
 */
public abstract class BaseAction extends ResponseTemplate {
	


	/** 获得json格式化响应内容 */
	protected ResultVo resultVo(int errorNo) {
		return  new ResultVo(errorNo,null);
	}
	/** 获得json格式化响应内容 */
	protected ResultVo resultVo(int errorNo, String errorMsg) {
		return new ResultVo(errorNo, errorMsg);
	}
	/** 获得json格式化响应内容 */
	protected ResultVo resultVo(int errorNo, String errorMsg, Object data) {
		return new ResultVo(errorNo, errorMsg, data);
	}

}
