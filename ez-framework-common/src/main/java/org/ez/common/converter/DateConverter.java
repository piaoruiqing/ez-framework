package org.ez.common.converter;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{
	
	@Value("${ez.request.date.pattern}")
	private String[] pattern = {"yyyy-MM-dd hh:mm:ss","yyyy-MM-dd hh:mm:ss.SSS"};

	@Override
	public Date convert(String source) {
		try {
			return DateUtils.parseDate(source, pattern);
		} catch (ParseException e) {
			return null;
		}
	}

}
