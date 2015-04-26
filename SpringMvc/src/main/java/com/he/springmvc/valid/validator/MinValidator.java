package com.he.springmvc.valid.validator;

import java.lang.annotation.Annotation;

import com.he.springmvc.annotation.Command;
import com.he.springmvc.annotation.Min;
import com.he.springmvc.valid.exception.ValidException;

@Command(argType = Integer.class, annoType = Min.class)
public class MinValidator implements Validator {

	private static Validator validator = new MinValidator();
	
	private MinValidator(){}
	
	public static Validator getInstance() {
		return validator;
	}
	@Override
	public boolean valid(Object arg, Annotation anno) throws ValidException {
		
		Min min = (Min) anno;
		Integer value = min.value();
		
		Integer ar = (Integer) arg;
		
		// 如果参数比age大 即符合条件
		if (value < ar) {
			return true;
		} else {
			throw new ValidException("Min Valid: value(" + ar + ") is smaller than min value(" + value + ")");
		}
	}

}
