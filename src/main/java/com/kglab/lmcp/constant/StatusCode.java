package com.kglab.lmcp.constant;

import com.kglab.lmcp.entity.vo.ResultVo;

public interface StatusCode {

	/** 系统全局异常状态码 */
	static final int SYSTEM_ERROR = -1000;

	/** 操作驳回状态码, 事务执行之前验证不通过 */
	static final int REBUT = -1;

	/** 事务操作失败状态码 */
	static final int FAIL = 0;

	/** 事务操作成功状态码 */
	static final int SUCCESS = 1;

	/** 特殊操作状态码 */
	static final int CUSTOM = 2;

	/** 事务操作成功，仅返回状态码：￥ **/
	final static ResultVo SUCCESS_Result = ResultVo.builder().no(SUCCESS).build();
	final static ResultVo REBUT_Result = ResultVo.builder().no(REBUT).build();
	final static ResultVo FAIL_Result = ResultVo.builder().no(FAIL).build();
	final static ResultVo CUSTOM_Result = ResultVo.builder().no(CUSTOM).build();

}
