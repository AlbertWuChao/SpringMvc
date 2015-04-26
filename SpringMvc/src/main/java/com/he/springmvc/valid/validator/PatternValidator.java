package com.he.springmvc.valid.validator;

import java.lang.annotation.Annotation;

import com.he.springmvc.annotation.Command;
import com.he.springmvc.annotation.Pattern;
import com.he.springmvc.valid.exception.ValidException;

@Command(argType = String.class, annoType = Pattern.class)
public class PatternValidator implements Validator {

	private static Validator validator = new PatternValidator();
	
	private PatternValidator(){}
	
	public static Validator getInstance() {
		return validator;
	}
	
	@Override
	public boolean valid(Object arg, Annotation anno) throws ValidException {
		String ar = (String) arg;
		Pattern pattern = (Pattern) anno;
		
		if (ar.matches(pattern.value())) {
			return true;
		} else {
			throw new ValidException("Pattern Valid: value(" + ar + ")" + "not match pattern(" + pattern + ")");
		}
	}

}
