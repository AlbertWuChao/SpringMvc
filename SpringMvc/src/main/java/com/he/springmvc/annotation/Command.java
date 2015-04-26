package com.he.springmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ϊ Validator ע�⣬��Ҫ������Ϲ涨�Ĳ������Ͳ���ʹ�� Validator
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

	@SuppressWarnings("rawtypes")
	Class argType();
	
	@SuppressWarnings("rawtypes")
	Class annoType();

	String description() default "";
}
