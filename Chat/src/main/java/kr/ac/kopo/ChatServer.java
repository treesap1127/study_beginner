package kr.ac.kopo;

import java.util.Vector;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatServer extends TextWebSocketHandler{
	//arrayList 보다 쓰레드에서 이슈가 없음
	Vector<WebSocketSession> list;
	
	public ChatServer() {
		super();
		
		if(list == null)
			list = new Vector<WebSocketSession>();
		
	}
	
	
	//연결이 성립됬을때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		
		list.add(session);
		
		System.out.println("연결: " +session.getRemoteAddress());
	}

	//사용자가 text메세지를 보냈을때
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		
		String user = (String) session.getAttributes().get("user");
		
		System.out.println("메세지: "+message.getPayload() + "," + user);
		
		for(WebSocketSession client : list) {
			client.sendMessage(new TextMessage(message.getPayload())); //playload() 사용자가 보낸 메세지
		}
		
		
	}
	
	//연결을 끊을때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		
		System.out.println("종료: "+session.getRemoteAddress());
		
		list.remove(session);
		
	}
	
}
