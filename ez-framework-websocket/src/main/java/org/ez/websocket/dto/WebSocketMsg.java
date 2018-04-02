package org.ez.websocket.dto;

import java.io.Serializable;

import org.ez.common.utils.ObjectMapperUtil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Web socket dto
 * @author Ruiqing.Piao
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketMsg implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String type;
	private Object data;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static String getMsgAsString(Object obj) {
		return ObjectMapperUtil.writeValueAsString(obj);
	}
	
}
