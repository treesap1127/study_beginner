package kr.ac.kopo;

import java.util.Vector;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatServer extends TextWebSocketHandler {
	Vector<WebSocketSession> list;//ArrayList는 혼자 볼때 Vector는 공유되는 데이터일때
	
	public ChatServer() {
		super();
		if(list==null)
			list = new Vector<WebSocketSession>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {//연결요청
		//연결 되는 시점에 port 번호가 생김-> webSocketSession에 저장시 켜야함 ↓ 그리고 리스트 for로 돌리면서 찾아서 메세지 보내기..?
		// 인원수 -> port 번호 하나씩 List 저장 - 보낼때 List에 있는거 for문 돌려서 각자 메세지 보내주기
		super.afterConnectionEstablished(session);
		
		list.add(session);
		System.out.println("연결:"+session.getRemoteAddress());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {//데이터송수신
		super.handleTextMessage(session, message);
		
		String user = (String) session.getAttributes().get("user");
		
		System.out.println("메세지:"+message.getPayload()+","+user);
		for(WebSocketSession client:list) {
			client.sendMessage(new TextMessage(message.getPayload()));//전부 보냄!
		}
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {//수신 끊김
		super.afterConnectionClosed(session, status);
		list.remove(session);
		System.out.println("종료"+session.getRemoteAddress());
	}
}
