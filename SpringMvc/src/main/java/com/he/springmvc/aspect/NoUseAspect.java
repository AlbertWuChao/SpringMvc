package com.he.springmvc.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.he.springmvc.valid.exception.ValidException;
import com.he.springmvc.valid.proxy.ValidProxy;

/**
 * 定义一个切面
 */
@Aspect
@Component
public class NoUseAspect {
	private static Logger logger = Logger.getLogger(NoUseAspect.class);
	
	/**
	 * 切点1
	 */
	@Pointcut("execution(* noUse(..))")
	private void cutNoUse() {}
	
	/**
	 * 切点2
	 */
	@Pointcut("execution(* *..*(..))")
	private void cutAll() {}
	
	@Pointcut(value="@annotation(com.he.springmvc.annotation.Valid)")
	private void argsValidCut() {}
	
	@Before("cutAll()")
	public void before() {
		System.out.println();
		logger.warn("before cutNoUse");
	}
	
	@Before(value = "argsValidCut()")
	public void validCut(JoinPoint jp) throws SecurityException, NoSuchMethodException, ValidException {
		Object[] objs = jp.getArgs();
		// 切点方法参数类型
		@SuppressWarnings("rawtypes")
		Class[] parameterTypes = ((MethodSignature)jp.getSignature()).getMethod().getParameterTypes();
		// 切点方法名
		String methodName = jp.getStaticPart().getSignature().getName();
		// 包含切点的类
		Object target = jp.getTarget();
		// 切点
		Method method = target.getClass().getMethod(methodName, parameterTypes);
		
		Annotation[][] annoss = method.getParameterAnnotations();
		int i = 0;
		for (Annotation[] annos : annoss) {
			// annos 是一个参数的数组列表
			for (Annotation anno : annos) {
				
				Object arg = objs[i];
				boolean flag = ValidProxy.valid(arg, anno);
				if (!flag) {
					@SuppressWarnings("rawtypes")
					Class[] annoTypes = anno.getClass().getInterfaces();
					String annoName = null;
					if (annoTypes == null || annoTypes.length == 0) {
						annoName = anno.getClass().getName();
					} else {
						annoName = annoTypes[0].getName();
					}
					throw new ValidException("Value(" + arg + ") not match type(" + annoName + ")");
				}
			}
			i++;
		}
	}
	
//	@Before("@args(com.he.springmvc.annotation.NotNul)")
//	public void beforeNotNull(JoinPoint jp) throws SecurityException, NoSuchMethodException {
//		System.out.println();
//		logger.warn("beforeNotNull com.he.springmvc.annotation.NotNull");
//		Object[] objs = jp.getArgs();
//		Class[] methodArgs = new Class[objs.length];
//		int i = 0;
//		for (Object obj : objs) {
//			System.out.println("obj: " + obj + "  Name: " + obj.getClass().getSimpleName());
//			methodArgs[i++] = obj.getClass();
//		}
//		logger.warn(jp.getTarget().getClass().getName());
//		logger.warn(jp.getKind());
//		
//		Object target = jp.getTarget();
//		String methodName = jp.getStaticPart().getSignature().getName();
//		Method method = target.getClass().getMethod(methodName, methodArgs);
//	}
	
	
}
