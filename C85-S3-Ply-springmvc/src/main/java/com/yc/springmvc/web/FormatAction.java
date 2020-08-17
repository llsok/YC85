package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmOrders;

@RestController
@RequestMapping("demo")
public class FormatAction {
	
	/**
	 * Field error in object 'dmOrders' on field 'date': 
	 * rejected value [2020-09-09]; codes 
	 * [typeMismatch.dmOrders.date,typeMismatch.date,typeMismatch.java.util.Date,typeMismatch]; 
	 * arguments [org.springframework.context.support.DefaultMessageSourceResolvable: 
	 * codes [dmOrders.date,date]; arguments []; default message [date]]; 
	 * default message [Failed to convert property value of type 
	 * 'java.lang.String' to required type 'java.util.Date' for property 'date'; 
	 * nested exception is org.springframework.core.convert.ConversionFailedException: 
	 * Failed to convert from type [java.lang.String] to type [java.util.Date] for value
	 *  '2020-09-09'; nested exception is java.lang.IllegalArgumentException]]
	 */
	
	@RequestMapping("addOrder")
	public DmOrders addOrder(DmOrders dos) {
		System.out.println(dos.getDate());
		return dos;
	}

}
