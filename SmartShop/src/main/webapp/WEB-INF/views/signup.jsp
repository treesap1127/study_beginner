<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
function check_id_Sync() {
   const form = document.getElementById("signup_form");
   
   const xhr = new XMLHttpRequest();
   
   xhr.open("GET", "checkId?id=" + form.id.value, false);
   //기다려야하는 동기 시스템을 만든거임
   xhr.send();
   
   const result = xhr.responseText;
   
   if(result == "OK") {
      alert(`[동기] \${form.id.value} 는 사용가능한 아이디 입니다`);
      form.checkId.value = form.id.value;
   }      
   else
      alert(`[동기] \${form.id.value} 는 이미 사용중인 아이디 입니다`);
}   

function check_id_Async() {
   const form = document.getElementById("signup_form");
   const xhr = new XMLHttpRequest();

   xhr.onreadystatechange = function() {
      console.log(xhr.readyState);
      
      if(xhr.readyState == XMLHttpRequest.DONE) {
         if(xhr.status == 200) {
            const result = xhr.responseText;
            
            if(result == "OK") {
               alert(`[비동기] \${form.id.value} 는 사용가능한 아이디 입니다`);
               form.checkId.value = form.id.value;
            }
            else
               alert(`[비동기] \${form.id.value} 는 이미 사용중인 아이디 입니다`);         
         }
      }
   }

   xhr.open("GET", `checkId?id=\${form.id.value}`, true);
   
   xhr.send(); //값을 받아오면 readystate 값 이 바뀐다 그러면 onreadystatechange 값이 변경되면서 함수 실해
   // readystate 이란 400 300 200 이란 것이다 대신 성공 했을때만 사용 가능한 아이디라 알리고 formcheck 아이디값을 넣어주기
   
}

function signup() {
   const form = document.getElementById("signup_form");
   const regx = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=()]).*$/;
   
   
   if(form.checkId.value != form.id.value) { //여기서 값이 같은거 확인
      alert("아이디 중복검사를 해 주세요");
      return;
   }
   
   if(form.id.value == "") {
      alert("아이디를 입력 해 주세요");
      form.id.focus();
      return;
   }
   
   if(form.passwd.value == "") {
      alert("비밀번호를 입력 해 주세요");
      form.passwd.focus();
      return;
   }
   if(!regx.test(form.passwd.value)){
	   alert("비밀번호 형식을 지켜주세요");
	   form.passwd.focus();
	   return;
   }
   
   if(form.passwd_confirm.value == "") {
      alert("비밀번호 확인를 입력 해 주세요");
      form.passwd_confirm.focus();
      return;
   }

   
   if(form.passwd.value != form.passwd_confirm.value) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
      form.passwd.value == "";
      form.passwd_confirm.value == "";
      form.passwd.focus();
      return;
   }
   
   
   if(form.address.value == "") {
      alert("주소를 입력 해 주세요");
      form.address.focus();
      return;
   }
   
   if(form.tel.value == "") {
      alert("전화번호를 입력 해 주세요");
      form.tel.focus();
      return;
   }
   form.submit();//회원가입 을 타입으로 따로 지정해줘서 결과값 전달을 해줘야함

}
</script>
</head>
<body>
   <div class="container">
      <form id="signup_form" method="post">
         <input type="hidden" name="checkId"> <%-- 여기엔 저장 시켜두는겨 --%>
         <div>
            <label>아이디:</label>
            <input type="text" name="id"> <button type="button" onclick="check_id_Async()">중복확인</button>
         </div>
         <div>
            <label>비밀번호:</label>
            <input type="password" name="passwd">
            <p>(특수문자,문자,숫자 포함 형태의 8~15자리 이내로 쓰시오)</p>
         </div>
         <div>
            <label>비밀번호 확인:</label>
            <input type="password" name="passwd_confirm">
         </div>
         <div>
            <label>주소:</label>
            <input type="text" name="address">
         </div>         
         <div>
            <label>전화번호:</label>
            
            <input type="text" name="tel">
         </div>
         <div>
            <button type="button" onclick="signup()">회원가입</button>
         </div>
      </form>
   </div>
</body>
</html>