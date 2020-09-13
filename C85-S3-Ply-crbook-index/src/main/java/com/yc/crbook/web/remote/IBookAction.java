package com.yc.crbook.web.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.crbook.bean.CrBook;

@FeignClient("crbook")
public interface IBookAction {
	
	@GetMapping("book/getNewBooks")
	List<CrBook> getNewBooks();

}
