package com.kglab.lmcp.global.handle.exception.service;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9063151662681391925L;

	public BusinessException(String errormsg) {
		super(errormsg);
	}
}
