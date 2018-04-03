package org.ez.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.ez.common.utils.ObjectMapperUtil;
import org.ez.websocket.dto.WebSocketMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Abstract web socket message handler
 * @author Ruiqing.Piao
 * 
 * @param <T>	entity
 */
public abstract class AbstractWebSocketMessageHandler extends AbstractWebSocketHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractWebSocketMessageHandler.class);
	
	protected Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();
	
	/**
	 * Send text message
	 * @date 2018/04/01 21:46:07
	 * @author Ruiqing.Piao
	 * @param entity
	 */
	public void sendTextMessage(WebSocketMsg msg) {
		if(null == msg || sessionMap.isEmpty()) {
			return ;
		}
		sessionMap.forEach((k,v)->{
			if(!v.isOpen()) {
				return ;
			}
			String jsonData = ObjectMapperUtil.writeValueAsString(msg);
			if(null == jsonData) {
				logger.error("message serialize error");
				return ;
			}
			TextMessage message = new TextMessage(jsonData);
			try {
				v.sendMessage(message);
			} catch (IOException e) {
				logger.error("websocket send error, data:{}",msg,e);
			}
		});
	}

	/**
	 * Handle the text message
	 * @date 2018/04/01 22:33:26
	 * @author Ruiqing.Piao
	 * @param msg
	 */
	protected abstract void handleTextMessage(WebSocketMsg msg);
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		byte[] bytes = message.asBytes();
		if(bytes.length <= 1 || bytes[0] != 123 || bytes[bytes.length-1] != 125) {
			// only handle json string
			// simple filter
			session.sendMessage(new TextMessage("message is not json string"));
			return ;
		}
		WebSocketMsg msg = ObjectMapperUtil.readValue(bytes,WebSocketMsg.class);
		if(null == msg) {
			session.sendMessage(new TextMessage("message deserialize error"));
			return ;
		}
		this.handleTextMessage(msg);
	}
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		super.handleBinaryMessage(session, message);
		// TODO
	}

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		super.handlePongMessage(session, message);
		// TODO
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionMap.put(session.getId(), session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionMap.remove(session.getId());
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// do something
	}

}
