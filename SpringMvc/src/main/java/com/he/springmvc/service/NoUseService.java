package com.he.springmvc.service;

import com.he.springmvc.bean.Key;

public interface NoUseService {

	void use(Key name);
	
	void noUse(String name, Integer age);
	
}
