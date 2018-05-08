package org.ez.common.format;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * simple date format <br/>
 * thread-safe
 * @author Ruiqing.Piao
 *
 */
public class SimpleDateFormat extends DateFormat{

	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd hh:mm:ss";
	private String[] pattern;
	
	public SimpleDateFormat() {
		this(DEFAULT_PATTERN);
	}
	public SimpleDateFormat(String... pattern) {
		this.pattern = pattern;
	}

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		return new StringBuffer(DateFormatUtils.format(date, DEFAULT_PATTERN));
	}

	@Override
	public Date parse(String source, ParsePosition pos) {
		Date date = null;
		try {
			date =  DateUtils.parseDate(source, pattern);
			pos.setIndex(1);
		} catch (ParseException e) {}
		return date;
	}
	
	@Override
	public Object clone() {
		return this;
	}

}
