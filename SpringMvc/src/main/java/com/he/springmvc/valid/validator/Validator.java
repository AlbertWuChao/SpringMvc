package com.he.springmvc.valid.validator;

import java.lang.annotation.Annotation;

import com.he.springmvc.valid.exception.ValidException;

public interface Validator {
	
	/**
	 * 格式正确返回 true, 格式错误返回 false
	 * 
	 * @param arg 参数对象
	 * @param anno 注解对象
	 * @return
	 * @throws ValidException 
	 */
	boolean valid(Object arg, Annotation anno) throws ValidException;
	

}
