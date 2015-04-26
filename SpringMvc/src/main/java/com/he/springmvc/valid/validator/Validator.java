package com.he.springmvc.valid.validator;

import java.lang.annotation.Annotation;

import com.he.springmvc.valid.exception.ValidException;

public interface Validator {
	
	/**
	 * ��ʽ��ȷ���� true, ��ʽ���󷵻� false
	 * 
	 * @param arg ��������
	 * @param anno ע�����
	 * @return
	 * @throws ValidException 
	 */
	boolean valid(Object arg, Annotation anno) throws ValidException;
	

}
