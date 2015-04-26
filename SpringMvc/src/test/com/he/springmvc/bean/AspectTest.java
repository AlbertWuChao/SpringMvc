package com.he.springmvc.bean;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.he.springmvc.service.NoUseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class AspectTest extends AbstractJUnit4SpringContextTests {
//	public class AspectTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource(name = "noUseService")
	private NoUseService noUserService;
	
	@Test
//	@Ignore
	public void testNoUse() {
		try {
		noUserService.noUse("KOCO", 19);
		System.out.println("---------------------");
		Key key = new Key();
		key.setKey("3 Key Key Key 3");
		noUserService.use(key);
		} catch (Exception e) {
			logger.error("AOP: ", e);
		}
	}
	
	@Test
	@Ignore
	public void ttt() {
//		OO(4);
		System.out.println(Object.class.isInstance(null));
	}
	
	public void OO(Object oo) {
		System.out.println(oo);
	}
	
}