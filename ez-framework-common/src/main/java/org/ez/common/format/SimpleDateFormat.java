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
	
	public static final String[] DEFAULT_PATTERN = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.SSS","yyyy-MM-dd"};
	private String[] pattern;
	
	public SimpleDateFormat() {
		this(DEFAULT_PATTERN);
	}
	
	public SimpleDateFormat(String... pattern) {
		if(pattern.length <= 0) {
			throw new IllegalArgumentException("pattern must not be empty");
		}
		this.pattern = pattern;
	}

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		return toAppendTo.append(DateFormatUtils.format(date, pattern[0]));
	}

	@Override
	public Date parse(String source, ParsePosition pos) {
		Date date = null;
		try {
			date =  DateUtils.parseDate(source, pattern);
			pos.setIndex(1);
		} catch (ParseException e) {
			// ignore
		}
		return date;
	}
	
	@Override
	public Object clone() {
//		return new SimpleDateFormat(pattern);
		return this;
	}
	
	@Override
	public int hashCode() {
		return pattern.hashCode();
	}

}
