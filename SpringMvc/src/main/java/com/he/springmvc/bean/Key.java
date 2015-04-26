package com.he.springmvc.bean;

import com.he.springmvc.annotation.NotNull;

public class Key {

	@NotNull
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "TestBean [key=" + key + "]";
	}

}
