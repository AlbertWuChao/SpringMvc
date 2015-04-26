package com.he.springmvc.valid.proxy;

import java.lang.annotation.Annotation;

import com.he.springmvc.annotation.Command;
import com.he.springmvc.annotation.Min;
import com.he.springmvc.annotation.NotNull;
import com.he.springmvc.annotation.Pattern;
import com.he.springmvc.valid.exception.ValidException;
import com.he.springmvc.valid.validator.MinValidator;
import com.he.springmvc.valid.validator.NotNullValidator;
import com.he.springmvc.valid.validator.PatternValidator;
import com.he.springmvc.valid.validator.Validator;

public class ValidProxy {
	
	public static boolean valid(Object arg, Annotation anno) throws ValidException {
		if (arg == null) {
			return false;
		}
		Validator validator = null;
		if (Min.class.isInstance(anno)) {
			validator = MinValidator.getInstance();
		} else if (NotNull.class.isInstance(anno)) {
			validator = NotNullValidator.getInstance();
		} else if (Pattern.class.isInstance(anno)) {
			validator = PatternValidator.getInstance();
		} else {
//			throw new NotSepportTypeException("Not sepport valid type: " + anno);
			return false;
		}
		
		Command command = validator.getClass().getAnnotation(Command.class);
		if (command == null) {
			return false;
		} else if (!validType(arg, anno, command)) {
			return false;
		} else {
			return validator.valid(arg, anno);
		}
	}
	
	private static boolean validType(Object arg, Annotation anno, Command command) {
		return command.argType().isInstance(arg) && command.annoType().isInstance(anno);
	}
	
	
}
