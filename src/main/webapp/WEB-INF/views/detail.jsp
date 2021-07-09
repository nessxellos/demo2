<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Detail</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	번호 : <span id="id">${ member.id }</span> <br/>
	이름 : ${ member.name } <br/>
	주소 : ${ member.addr } <br/>
	이메일 : ${ member.email } <br/>
	메모 : ${member.memo }<br/>
	
	<br/>
	<a href="/update/${member.id }">회원정보 수정하기</a>
	
	<button type="button" id="btnDelete">탈퇴하기</button><br/><br/>
	
	<a href="/delete/${ member.id }">탈퇴하기</a> <br/>
	<a href="/">돌아가기</a> <br/><br/>
<script src="/js/member.js">

</script>
</body>
</html>