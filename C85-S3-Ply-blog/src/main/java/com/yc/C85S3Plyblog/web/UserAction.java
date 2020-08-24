package com.yc.C85S3Plyblog.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.C85S3Plyblog.bean.Result;
import com.yc.C85S3Plyblog.bean.User;
import com.yc.C85S3Plyblog.biz.BizException;
import com.yc.C85S3Plyblog.biz.UserBiz;

@Controller // 默认控制器方法是执行页面跳转
public class UserAction {

	@Resource
	private UserBiz ubiz;

	/**
	 * 	注册 : 表单提交 ==> 页面跳转
	 * 	Errors 报错所有的验证错误信息,   默认会被推送页面
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user, Errors errors, Model m) {
		if (errors.hasErrors()) {
			m.addAttribute("errors", asMap(errors));
			m.addAttribute("user", user);
			return "reg";
		}
		try {
			ubiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account", e.getMessage());
			m.addAttribute("errors", asMap(errors));
			m.addAttribute("user", user);
			return "reg";
		}
		// index 请求转发方式跳转到 index
		// 使用响应重定向方式跳转
		return "redirect:/"; 
	}

	@GetMapping("toreg")
	public String toreg() {
		return "reg";
	}

	/**
	 * 	登录: Ajax提交 ==> Vue
	 */
	@PostMapping("login.do")
	public Result login(User user, HttpSession session) {
		try {
			User dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
		return new Result(1, "登录成功!");
	}

	/**
	 * 	将所有的字段验证错写入到一个map
	 * @param errors
	 * @return
	 */
	private Map<String, String> asMap(Errors errors) {
		if (errors.hasErrors()) {
			Map<String, String> ret = new HashMap<String, String>();
			for (FieldError fe : errors.getFieldErrors()) {
				ret.put(fe.getField(), fe.getDefaultMessage());
			}
			return ret;
		} else {
			return null;
		}
	}

}
