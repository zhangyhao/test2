package com.zhangyuhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyuhao.entity.Applicant;
import com.zhangyuhao.entity.Job;
import com.zhangyuhao.service.AppService;

@Controller
public class AppController {

	@Autowired
	private AppService service;
	//列表方法
	//我是源文件
	//我是测试文件 
	@RequestMapping("list.do")
	public  Object list(Model m,@RequestParam(defaultValue="1")int pageNum){
		//分页
		PageHelper.startPage(pageNum, 2);
		List<Applicant> list = service.list();
		PageInfo<Applicant> pg = new PageInfo<Applicant>(list);
		m.addAttribute("list", list);
		m.addAttribute("pg", pg);
		return "list";
	}
	//根据主持90分以上
	@RequestMapping("jname.do")
	public Object jname(Model m){
		List<Applicant> list = service.avg();
		m.addAttribute("list", list);
		return "list";
	}
	//平均80分以上
	@RequestMapping("avg.do")
	public Object avg(Model m){
		List<Applicant> list = service.ping();
		m.addAttribute("list", list);
		return "list";
	}
	//研究生以上
	@RequestMapping("edu.do")
	public Object edu(Model m){
		List<Applicant> list = service.edu();
		m.addAttribute("list", list);
		return "list";
	}
	//添加前给方法
	@RequestMapping("toadd.do")
	public Object toadd(Model m){
		m.addAttribute("a", new Applicant());
		return "add";
	}
	//添加
	@RequestMapping("add.do")
	public Object add(@Valid@ModelAttribute("a")Applicant a,BindingResult result){
		//自定义验证
		if(a.getEdu()==1 ||a.getEdu()==2){
			if(a.getDegree()>=2){
				result.rejectValue("edu", "", "学位只能是学士");
			}
		}
		//验证判断
		if(a.getEdu()==3){
			if(a.getDegree()<2){
				result.rejectValue("edu", "", "学位只能是硕士或博士");
			}
		}
		//判断是否有错误
		if(result.hasErrors()){
			//返回给添加页面
			return "add";
		}
		service.add(a);
		return "redirect:list.do";
	}
	//修改前回显及下拉框回显
	@RequestMapping("toupdate.do")
	public Object toupdate(Integer aid,Model m,HttpSession session){
		Applicant a = service.toupdate(aid);
		List<Job> list = service.job();
		m.addAttribute("a", a);
		m.addAttribute("list", list);
		session.setAttribute("a", a);
		//返回jsp
		return "update";
	}
	//修改
	@RequestMapping("update.do")
	public Object update(@Valid@ModelAttribute("a")Applicant a,BindingResult result,Model m){
		//判断
		if(a.getJid()<0){
			result.rejectValue("jid", "", "请选择职位");
		}
		if(a.getScore()==null){
			result.rejectValue("score", "", "成绩不能为空");
		}
		if(result.hasErrors()){
			List<Job> list = service.job();
			m.addAttribute("list", list);
			return "update";
		}
		///执行修改
		service.update(a);
		return "redirect:list.do";
	}
	//删除
	@ResponseBody
	@RequestMapping("del.do")
	public Object del(Integer aid){
		boolean flag = service.del(aid);
		return flag;
	}
}
