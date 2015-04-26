package com.he.springmvc.valid.validator;

import java.lang.annotation.Annotation;

import com.he.springmvc.annotation.Command;
import com.he.springmvc.annotation.NotNull;
import com.he.springmvc.valid.exception.ValidException;

@Command(annoType = NotNull.class, argType = Object.class)
public class NotNullValidator implements Validator {

	private static Validator validator = new NotNullValidator();
	
	private NotNullValidator() {}
	
	public static Validator getInstance() {
		return validator;
	}
	
	@Override
	public boolean valid(Object arg, Annotation anno) throws ValidException {
		if (arg == null) {
			throw new ValidException("NotNull Valid: value can`t be null");
		}
		return true;
	}
	
}
