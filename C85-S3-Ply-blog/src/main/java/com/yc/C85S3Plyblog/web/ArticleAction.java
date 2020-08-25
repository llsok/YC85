package com.yc.C85S3Plyblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.C85S3Plyblog.bean.Article;
import com.yc.C85S3Plyblog.biz.ArticleBiz;
import com.yc.C85S3Plyblog.util.Utils;

@RestController
public class ArticleAction {

	@Resource
	private ArticleBiz abiz;

	/*@GetMapping("toAddArticle")
	public String toAddArticle() {
		return "addArticle";
	}*/

	@GetMapping("toAddArticle")
	public ModelAndView toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return mav;
	}

	@PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article a, Errors errors, ModelAndView mav) {
		// ModelAndView = Model + View
		if (errors.hasErrors()) {
			mav.addObject("errors", Utils.asMap(errors));
			mav.addObject("article", a);
			mav.setViewName("addArticle");
		} else {
			mav.setViewName("article"); // 未完待续 .. 展示新添加的文章
		}
		return mav;
	}

}
