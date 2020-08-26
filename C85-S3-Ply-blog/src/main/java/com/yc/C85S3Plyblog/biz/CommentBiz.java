package com.yc.C85S3Plyblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C85S3Plyblog.bean.Comment;
import com.yc.C85S3Plyblog.dao.CommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private CommentMapper cMapper;
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}

}
