$("#btnDelete").click(function(){
	

	$.ajax({
		type:"DELETE",
		url:"/delete/"+$("#id").text()

	})
	.done(function(resp){
		alert("삭제성공")
		location.href="/list"
	})
	.fail(function(){
		
	})
})

$("#btnUpdate").click(function(){
	var dataParam={
		"email" : $("#email").val(),
		"addr" : $("#addr").val(),
		"memo" : $("#memo").val(),
		"password" : $("#password").val(),
		"id" : $("#id").val(),
	}

	$.ajax({
		type:"PUT",
		url:"/update/",
		data: JSON.stringify(dataParam),
		contentType:"application/json;charset=uft-8"
	})
	.done(function(){
		alert("정보 수정 성공")
		location.href="/list"
	})
	.fail(function(){
		alert("정보 수정 실패")
	})
})