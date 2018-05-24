package org.ez.common.exception.support;

import org.ez.common.exception.ExceptionHandler;
import org.ez.common.exception.entity.MessageException;
import org.ez.common.utils.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class MessageExceptionHandler implements ExceptionHandler {

	@Override
	public ModelAndView handle(Exception ex) {
		if(null == ex) {
			return null;
		}
		if(ex instanceof MessageException) {
			ModelAndView mav = new ModelAndView();
			MappingJackson2JsonView view = new MappingJackson2JsonView();
			view.setAttributesMap(ResponseData.failure(ex.getMessage()).convertToMap());
			mav.setView(view);
			return mav;
		}
		return null;
	}

}
