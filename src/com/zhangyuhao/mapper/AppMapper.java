package com.zhangyuhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangyuhao.entity.Applicant;
import com.zhangyuhao.entity.Job;

public interface AppMapper {
	//全查
	List<Applicant> list();
	//主持90分以上
	List<Applicant> avg();
	//平均值
	List<Applicant> ping();
	//研究生
	List<Applicant> edu();
	//添加
	@Insert("insert into cctv_applicant values(null,#{name},#{gender},#{birthday},#{college},#{major}"
			+ ",#{edu},#{degree},now())")
	void add(Applicant a);
	//修改回显
	@Select("select * from cctv_applicant where aid=#{aid}")
	Applicant toupdate(@Param("aid")Integer aid);
	//下拉框
	@Select("select * from cctv_job")
	List<Job> job();
	//添加成绩
	@Insert("insert into cctv_score values(#{aid},#{jid},#{score})")
	void addScore(Applicant a);
	//删除应聘者
	@Delete("delete from cctv_applicant where aid=#{aid}")
	boolean del(Integer aid);
	//删除中间表
	@Delete("delete from cctv_score where aid=#{aid}")
	void delScore(Integer aid);


}
