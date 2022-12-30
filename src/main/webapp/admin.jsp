<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
<link rel="stylesheet" type="text/CSS" href="admin.css">
</head>
<body>

	<%@ include file="nav.jsp"%>
	
	<div class="form-admin">
		<form action="adminLogin" method="post">
			<h2>Admin details :</h2>
			<label for="name">Name</label>
			<br>
			<input id="name" type="text" name="adname">
			<br>
			<label for="pass">Password</label> <br>
			<input id="pass" type="password" name="adpassword">
			<br>
			<button type="submit">Login</button> <br>
		</form>
	</div>
</body>
</html>