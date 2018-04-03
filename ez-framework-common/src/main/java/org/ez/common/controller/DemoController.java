package org.ez.common.controller;

import org.ez.common.utils.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo")
public class DemoController {

	@RequestMapping(value="/test",method= {RequestMethod.GET})
	public ResponseData test() {
		throw new NullPointerException("测试运行时异常");
//		throw new RuntimeException("测试运行时异常");
//		return ResponseMessage.success(new Object[] {"str1","str2"});
	}
	
}
