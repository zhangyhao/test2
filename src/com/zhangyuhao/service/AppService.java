package com.zhangyuhao.service;

import java.util.List;

import com.zhangyuhao.entity.Applicant;
import com.zhangyuhao.entity.Job;

public interface AppService {
	//全查
	List<Applicant> list();
	//主持90分
	List<Applicant> avg();
	//平均80分
	List<Applicant> ping();
	//研究生
	List<Applicant> edu();
	//添加
	void add(Applicant a);
	//修改前回显
	Applicant toupdate(Integer aid);
	//全查工作，下拉框回显
	List<Job> job();
	//执行修改
	void update(Applicant a);
	//执行删除
	boolean del(Integer aid);

}
