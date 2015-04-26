package com.he.springmvc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.he.springmvc.annotation.Min;
import com.he.springmvc.annotation.NotNull;
import com.he.springmvc.annotation.Valid;
import com.he.springmvc.bean.Key;
import com.he.springmvc.service.NoUseService;

@Service("noUseService")
public class NoUseServiceImpl implements NoUseService {
	private static final Logger logger = Logger.getLogger(NoUseServiceImpl.class);

	@Override
	@Valid
	public void use(@NotNull Key name) {
		System.out.println();
		logger.warn("Cal method use of NoUseServiceImpl, name: " + name);
		System.out.println();
	}

	@Override
	@Valid
	public void noUse(@NotNull String name, @Min(18) Integer age) {
		System.out.println();
		logger.warn("Cal method noUse of NoUseServiceImpl, name: " + name + " age: " + age);
		System.out.println();
	}

}
