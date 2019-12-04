package com.zhangyuhao.entity;

public class Job {
    private Integer jid;
	private String name;
	private int require_edu;
	private int require_degree;
	private String intro;
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequire_edu() {
		return require_edu;
	}
	public void setRequire_edu(int require_edu) {
		this.require_edu = require_edu;
	}
	public int getRequire_degree() {
		return require_degree;
	}
	public void setRequire_degree(int require_degree) {
		this.require_degree = require_degree;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
