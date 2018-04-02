package org.ez.websocket.handler;

import org.ez.common.entity.DemoEntity;
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
public class DemoWebSocketMessageHandler extends AbstractWebSocketMessageHandler<DemoEntity> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void handleTextMessage(WebSocketMsg msg) {
		logger.info(ObjectMapperUtil.writeValueAsString(msg));
	}
	
}
