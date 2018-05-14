package org.ez.common.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.ez.common.entity.DemoEntity;
import org.ez.common.exception.entity.MessageException;
import org.ez.common.service.IDemoService;
import org.ez.common.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo")
public class DemoController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IDemoService demoService;
	
	@RequestMapping(value = "/date", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseData DateConverter(@RequestParam(required = true) Date date) {
		logger.info("receive date test");
		return ResponseData.success(date);
	}

	@RequestMapping(value = "/create",method = {RequestMethod.GET})
	public ResponseData create() {
		logger.info("create a demo entity");
		DemoEntity entity = new DemoEntity();
		entity.setIndexCode(UUID.randomUUID().toString().replaceAll("-", ""));
		entity.setDelete(0);
		entity = demoService.save(entity);
		return ResponseData.success(entity);
	}
	
	@RequestMapping(value = "/get",method = {RequestMethod.GET})
	public ResponseData get(@RequestParam(name = "id")Long id) {
		logger.info("get a demo entity");
		DemoEntity entity = demoService.findById(id);
		return ResponseData.success(entity);
	}
	
	@RequestMapping(value = "/exception",method = {RequestMethod.GET})
	public ResponseData exception(@RequestParam(required = false)String exception) {
		logger.info("test exception handler");
		if (StringUtils.equals("NullPointerException", exception)) {
			throw new NullPointerException("测试空指针异常");
		} else if(StringUtils.equals("MessageException", exception)){
			throw new MessageException("测试消息异常");
		} else {
			throw new RuntimeException("测试运行时异常");
		}
	}
	
}
