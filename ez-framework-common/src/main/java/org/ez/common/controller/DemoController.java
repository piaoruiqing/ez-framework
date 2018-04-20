package org.ez.common.controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.ez.common.dao.DemoRepository;
import org.ez.common.entity.DemoEntity;
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
	private DemoRepository demoRepository;

	@RequestMapping(value="/create",method= {RequestMethod.GET})
	public ResponseData create() {
		logger.info("create a demo entity");
		DemoEntity entity = new DemoEntity();
		entity.setIndexCode(UUID.randomUUID().toString().replaceAll("-", ""));
		entity.setDelete(0);
		entity = demoRepository.save(entity);
		return ResponseData.success(entity);
	}
	
	@RequestMapping(value="/get",method= {RequestMethod.GET})
	public ResponseData get(@RequestParam(name = "id")Long id) {
		logger.info("get a demo entity");
		DemoEntity entity = demoRepository.findById(id).orElse(null);
		return ResponseData.success(entity);
	}
	
	@RequestMapping(value="/exception",method= {RequestMethod.GET})
	public ResponseData exception(@RequestParam(defaultValue = "NullPointerException")String exception) {
		logger.info("test exception handler");
		if(StringUtils.equals("NullPointerException", exception)) {
			throw new NullPointerException("测试运行时异常");
		}else {
			throw new RuntimeException("测试运行时异常");
		}
	}
	
}
