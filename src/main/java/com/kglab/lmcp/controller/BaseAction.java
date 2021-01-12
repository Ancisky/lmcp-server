package com.kglab.lmcp.controller;

import com.kglab.lmcp.constant.StatusCode;
import com.kglab.lmcp.entity.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

public abstract class BaseAction{
	
	protected final static int SUCCESS = StatusCode.SUCCESS;
	protected final static int FAIL = StatusCode.FAIL;
	protected final static int REBUT = StatusCode.REBUT;
	protected final static int CONSTOM = StatusCode.CONSTOM;

	/** 事务操作成功，仅返回状态码：￥ **/
	protected final static ResultVo SUCCESS_Result = ResultVo.builder().no(SUCCESS).build();
	protected final static ResultVo REBUT_Result = ResultVo.builder().no(REBUT).build();
	protected final static ResultVo FAIL_Result = ResultVo.builder().no(FAIL).build();


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

	/**  **/
	protected ResultVo success(String errorMsg, Object data) {
		return  new ResultVo(SUCCESS, errorMsg, data);
	}
	protected ResultVo fail(String errorMsg) {
		return  new ResultVo(FAIL, errorMsg);
	}
	protected ResultVo rebut(String errorMsg) {
		return  new ResultVo(REBUT, errorMsg);
	}

}
