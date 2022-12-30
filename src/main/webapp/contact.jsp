<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contact</title>
<link rel="stylesheet" type="text/CSS" href="aboutstyle.css">
</head>
<body>
	
	<%@ include file="nav.jsp"%>
	<div class="form-contact">
		<form action="Contact" method ="post">
			<label for="name">Name:</label><br>
			<input id="name" type="text" name="name"><br>
		
			<label for="phone">Phone number</label><br>
			<input id="phone" type="text" name="phone"><br>
		
			<label for="mail">E-mail:</label><br>
			<input id="mail" type="mail" name="mail"><br>
		
			<label for="comment">comments:</label><br>
			<textarea id="comment" name="comment"></textarea>
			<br>
			
			<button type="submit">Submit</button>
		</form>
		
	</div>
	
</body>
</html>