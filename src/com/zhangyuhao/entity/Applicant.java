package com.zhangyuhao.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Applicant {
    private Integer aid;
    
    @NotBlank(message="应聘人不能空")
    @Pattern(regexp="\\W{2,10}",message="姓名最少不能少于2个字符")
	private String name;
    @NotNull(message="性别不能空")
	private Gender gender;
	@NotBlank(message="生日不能为空")
	private String birthday;
	@Pattern(regexp="\\W{2,10}",message="毕业大学最少不能少于2个字符")
	@NotBlank(message="毕业大学不能为空")
	private String college;
	@Pattern(regexp="\\W{2,10}",message="所学专业最少不能少于2个字符")
	@NotBlank(message="所学专业不能为空")
	private String major;
	@NotNull(message="学历不能空")
	private int edu;
	@NotNull(message="学位不能空")
	private int degree;
	private String created;
	private String jname;
	private int avg;
	
	private Integer jid;
	
	private Integer score;
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getEdu() {
		return edu;
	}
	public void setEdu(int edu) {
		this.edu = edu;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Applicant [aid=" + aid + ", name=" + name + ", gender="
				+ gender + ", birthday=" + birthday + ", college=" + college
				+ ", major=" + major + ", edu=" + edu + ", degree=" + degree
				+ ", created=" + created + ", jname=" + jname + ", avg=" + avg
				+ ", jid=" + jid + ", score=" + score + "]";
	}
	
	
}
