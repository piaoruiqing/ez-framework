package org.ez.common.exception;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ez.common.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * global exception handler
 * @author Ruiqing.Piao
 *
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver,BeanPostProcessor{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private List<ExceptionHandler> exceptionHandler = new CopyOnWriteArrayList<>(); 

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.error("handle exception",ex);
		for(Iterator<ExceptionHandler> iterator = exceptionHandler.iterator();iterator.hasNext();) {
			ModelAndView mav = iterator.next().handle(ex);
			if(null != mav) {
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setAttributesMap(ResponseData.failure("unknow error").convertToMap());
		mav.setView(view);
		return mav;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof ExceptionHandler) {
			exceptionHandler.add((ExceptionHandler)bean);
		}
		return bean;
	}

}