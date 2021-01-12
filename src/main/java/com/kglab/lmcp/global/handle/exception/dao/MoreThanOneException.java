package com.kglab.lmcp.global.handle.exception.dao;
public class MoreThanOneException extends RuntimeException {
    /** 
	 * <br><br>
	 * 
	 * @Date 2018年5月28日
	 * @Author 舒超
	 */ 
	private static final long serialVersionUID = 4183532908072296921L;

	public MoreThanOneException(){
        super("error: the result is more than one.");
    }
}