package com.kglab.lmcp.constant;

public class StatusCode {
	/** 系统全局异常状态码 */
	public static final int SYSTEM_ERROR = -1000;
	
	/** 操作驳回状态码, 事务执行之前验证不通过 */
	public static final int REBUT = -1;
	
	/** 事务操作失败状态码 */
	public static final int FAIL = 0;
	
	/** 事务操作成功状态码 */
	public static final int SUCCESS = 1;
	
	/** 特殊操作状态码 */
	public static final int CONSTOM = 2;
}
