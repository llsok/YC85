package com.yc.crbook.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.Result;

@FeignClient("cruser")
public interface IUserAction {
	
	/**
	 * Feigin 要求对象参数标注 @RequestBody 注解 
	 */
	@PostMapping("user/login")
	Result login(@RequestBody CrUser user);

}
