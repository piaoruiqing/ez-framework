package org.ez.common.exception;

import org.springframework.web.servlet.ModelAndView;

public interface ExceptionHandler {
	
	ModelAndView handle(Exception ex);
	
}
