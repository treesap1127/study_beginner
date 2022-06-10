<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
const url = "ws://" + window.location.hostname+":" + window.location.port + "/kopo/chatserver";
const socket = new WebSocket(url);

let connect = false;

socket.onopen = () =>{
	connect = true;
	alert("서버에 연결 되었습니다");
}

socket.onclose = () =>{
	connect = false;
	alert("서버 연결이 종료 되었습니다");
}

socket.onmessage = msg =>{
	const chat = document.getElementById("chat");
	
	console.dir(msg);
	
	chat.innerHTML +="<li>" +msg.data+"</i>";
}

function send(){
	if(connect){
		const nickname = document.getElementById("nickname");
		const msg = document.getElementById("msg");
		
		socket.send(nickname.value + ": "+msg.value);
		
		msg.value ="";
		
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
			<input id="nickname" type="text" value="익명">
		</div>
		<div>
			<label>메세지:</label>
			<input id="msg" type="text">
			<button onclick="send()">보내기</button>
		</div>
	</div>
</body>
</html>