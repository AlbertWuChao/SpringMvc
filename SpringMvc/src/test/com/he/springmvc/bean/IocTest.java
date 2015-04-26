package com.he.springmvc.bean;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
	
	private static AbstractXmlApplicationContext beanFactory;
	private static Logger logger = Logger.getLogger(IocTest.class);
	
	@BeforeClass
	public static void doAtFirst() {
		beanFactory = new ClassPathXmlApplicationContext("spring-core.xml");
	}
	
	@Test
	public void testIoc() {
		logger.info("test ioc");
	}
}
