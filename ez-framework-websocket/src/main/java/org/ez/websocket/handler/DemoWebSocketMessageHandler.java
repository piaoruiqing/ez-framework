package org.ez.websocket.handler;

import java.util.UUID;

import org.ez.common.utils.ObjectMapperUtil;
import org.ez.websocket.AbstractWebSocketMessageHandler;
import org.ez.websocket.dto.WebSocketMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web socket message handler demo
 * @author Ruiqing.Piao
 * 
 */
public class DemoWebSocketMessageHandler extends AbstractWebSocketMessageHandler {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void handleTextMessage(WebSocketMsg msg) {
		// do somthing
		logger.info(ObjectMapperUtil.writeValueAsString(msg));
		logger.info((String)msg.getData());
		WebSocketMsg returnMsg = new WebSocketMsg(msg.getData());
		returnMsg.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		returnMsg.setType("RETURN_MSG");
		this.sendTextMessage(returnMsg);
	}
	
}
