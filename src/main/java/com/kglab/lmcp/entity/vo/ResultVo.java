package com.kglab.lmcp.entity.vo;

import lombok.Builder;
import lombok.Data;

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
