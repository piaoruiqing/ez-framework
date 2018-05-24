package org.ez.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoServiceAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* org.ez.common.service.impl.DemoServiceImpl.save(..))")
	public void save() {}
	
	@Before("save()")
	public void before() {
		logger.info("before save()");
	}
	
	@After("save()")
	public void after() {
		logger.info("after save()");
	}
	
	@AfterReturning("save()")
	public void afterReturning() {
		logger.info("after returning save()");
	}
	
	@AfterThrowing("save()")
	public void afterThrowing() {
		logger.info("after throwing save()");
	}
	
	@Around("save()")
	public Object around(ProceedingJoinPoint pdj) {
		logger.info("around save()");
		Object result = null;
		try {
			result =  pdj.proceed();
		} catch (Throwable e) {
			logger.error("around save()",e);
		}
		return result;
	}
	
}
