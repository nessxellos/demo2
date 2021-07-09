<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h3>Join us</h3>
<form action="join" method="post">
Name :  <input type="text" name="name"><br/>
Password : <input type="password" name="password"><br/>
Email: <input type="text" name="email"><br/>
Addr : <input type="text" name="addr"><br/>
Memo : <textarea rows="5" cols="50" name="memo"></textarea>
<button>Submit</button>
</form>
</body>
</html>