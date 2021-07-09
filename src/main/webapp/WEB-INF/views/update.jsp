<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update your information</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<h3>Update your information</h3>
	
Num : <input type="text" name="id" id="id" value=${member.id } readonly="readonly"><br/>
Name :  <input type="text" name="name" id="name" value="${member.name }" readonly="readonly"><br/>
Password : <input type="password" name="password" id="password"><br/>
Email: <input type="text" name="email" id="email" value="${member.email }"><br/>
Addr : <input type="text" name="addr" id="addr" value="${member.addr }"><br/>
Memo : <textarea rows="5" cols="50" name="memo" id="memo">${member.memo }</textarea>
<button type="button" id="btnUpdate">수정하기</button>
<script src="/js/member.js"></script>
</body>
</html>