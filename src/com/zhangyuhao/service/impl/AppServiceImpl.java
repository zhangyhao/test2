package com.zhangyuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyuhao.entity.Applicant;
import com.zhangyuhao.entity.Job;
import com.zhangyuhao.mapper.AppMapper;
import com.zhangyuhao.service.AppService;
@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private AppMapper mapper;
	//列表
	@Override
	public List<Applicant> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}
	//主持90分
	@Override
	public List<Applicant> avg() {
		// TODO Auto-generated method stub
		return mapper.avg();
	}
	//平均80分
	@Override
	public List<Applicant> ping() {
		// TODO Auto-generated method stub
		return mapper.ping();
	}
	//研究生
	@Override
	public List<Applicant> edu() {
		// TODO Auto-generated method stub
		return mapper.edu();
	}
	//添加
	@Override
	public void add(Applicant a) {
		// TODO Auto-generated method stub
		mapper.add(a);
	}

	@Override
	public Applicant toupdate(Integer aid) {
		// TODO Auto-generated method stub
		return mapper.toupdate(aid);
	}
	//下拉框回显
	@Override
	public List<Job> job() {
		// TODO Auto-generated method stub
		return mapper.job();
	}
	//修改
	@Override
	public void update(Applicant a) {
			mapper.addScore(a);
	}
	//删除
	@Override
	public boolean del(Integer aid) {
		mapper.delScore(aid);
		return mapper.del(aid);
	}
}
