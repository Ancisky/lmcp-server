package com.kglab.lmcp.global.handle.exception.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResultVoMessage extends RuntimeException{

	protected int errorNo;
	protected String errorMsg;
	protected Object data;
	public ResultVoMessage(int errorNo, String errorMsg){
		super();
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
	}
	public ResultVoMessage(int errorNo, String errorMsg, Object data){
		super();
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	private ResultVoMessage(){
		super();
	}

}
