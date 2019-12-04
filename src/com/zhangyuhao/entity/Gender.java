package com.zhangyuhao.entity;

public enum Gender {
	MAN("男"),WOMAN("女");
	
	private String display;

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	private Gender(String display) {
		this.display = display;
	}

	
}
