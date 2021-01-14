package com.kglab.lmcp.entity.vo;

import lombok.Builder;
import lombok.Data;
/**
 * TODO 全局通用响应数据类型（controller中返回的对象类型）
 * @author sc
 * @date 2021/1/14
 */
@Data
@Builder
public class ResultVo {

	private int no;
	private String msg;
	private Object data;
	
	public ResultVo(){ super(); }
	
	public ResultVo(int errorNo,String errorMsg){
		super();
		this.no = errorNo;
		this.msg = errorMsg;
	}
	public ResultVo(int errorNo,String errorMsg,Object data){
		super();
		this.no = errorNo;
		this.msg = errorMsg;
		this.data = data;
	}
	public void setResultVo(int errorNo,String errorMsg,Object data){
		this.no = errorNo;
		this.msg = errorMsg;
		this.data = data;
	}
}
