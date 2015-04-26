package com.he.springmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 为 Validator 注解，需要传入符合规定的参数类型才能使用 Validator
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
