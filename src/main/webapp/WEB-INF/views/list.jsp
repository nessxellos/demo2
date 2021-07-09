<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<!-- 페이징을 할 경우 .content를 추가해야 오류가 밠생하지 않음 -->
<div id="memberDiv">
<c:forEach items="${ lists.content }" var="member"><br/>
	번호 : ${ member.id } <br/>
	이름 : ${ member.name } <br/>
	주소 : ${ member.addr } <br/>
	이메일 : ${ member.email } <br/>
	<a href="detail/${ member.id }">상세보기</a> <br/>
<button type="button" onclick="funcDelete(${member.id})">삭제</button>
<button type="button" class="btnDel" data-mid="${member.id}">삭제 class</button><br/><br/>
</c:forEach>
</div>
<a href="?page=${lists.number-1 }">이전</a>
<a href="?page=${lists.number+1 }">다음</a>
<c:choose>
	<c:when test="${lists.first }">
		[First]
	</c:when>
	<c:when test="${lists.last }">
	[Last]
	</c:when>
</c:choose>
<script>
function funcDelete(id){
	$.ajax({
		type:"DELETE",
		url:"/delete/"+id

	})
	.done(function(resp){
		alert("삭제성공")
		location.href="/list"
	})
}
$("#memberDiv").on("click",".btnDel", function(){
	$.ajax({
		type:"DELETE",
		url:"/delete/"+$(this).attr("data-mid")

	})
	.done(function(resp){
		alert("삭제성공")
		location.href="/list"
	})
}) 
</script>
</body>
</html>