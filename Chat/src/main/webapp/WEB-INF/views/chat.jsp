<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	const url ="ws://"+window.location.hostname+":"	+window.location.port+"/chatserver";//코포지움
	
	const socket=new WebSocket(url);
	
	let connect = false;
	
	socket.onopen=()=>{
		connect=true;
		alert("서버연결 완료");
	}
	socket.onclose=()=>{
		connect=false;
		alert("서버연결 종료");
	}
	
	socket.onmessage=msg=>{//메세지 받아온거
		const chat = document.getElementById("chat");
		
		console.log(msg+"= 메세지");
		
		chat.innerHTML += "<li>" +msg.data+"</li>";
	}
	function send(){//메세지 입력
		if(connect){
			const nickname = document.getElementById("nickname");
			const msg =docment.getElementById("msg");
			
			socket.send(nickname.value+":"+msg.value);//이거 하나로 보냄..
			msg.value="";// 보낸메세지 비우기
		}
	}
</script>
</head>
<body>
	<div>
		<div>
			<ul id="chat"></ul>
		</div>
		<div>
			<label>발신자:</label>
			<input id="nickname" type="text" value="익명"/>
	<hr>
			<label>메세지:</label>
			<input id="msg" type="text"/>
		</div>
		
		<div>
			<button onclick="send()">보내기</button>
		</div>
	</div>
</body>
</html>