package org.ez.common.exception.entity;

public class MessageException extends RuntimeException {

	private static final long serialVersionUID = 6777243171574170324L;

	public MessageException() {
		super();
	}
	
	public MessageException(String message){
		super(message);
	}
	
	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MessageException(Throwable cause) {
		super(cause);
	}
	
	public MessageException(String message, Throwable cause,
				            boolean enableSuppression,
				            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
