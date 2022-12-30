<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newReg</title>
<link rel="stylesheet" type="text/CSS" href="reg.css">
</head>
<body>
	<%@ include file="adminnav.jsp"%>
	
	<div class="form-nwreg">
		<form action="RegisterVoter" method="post">
			<h2>Enter Your Details</h2><br>
			<label for="name">Name :</label><br>
			<input id="name" type="text" name="rgname"><br>
			
			<label for="phno">Phone number :</label><br>
			<input id="phno" type="number" name="phno"><br>
			
			<label for="mail">Email :</label><br>
			<input id="mail" type="mail" name="mail"><br>
			
			<label for="voterno">Voter Card Number :</label><br>
			<input id="voterno" type="number" name="voterno"><br>
			
			<label for="add">Address :</label><br>
			<textarea id="add" name="add" row="4"></textarea><br>
			
			<label for="bday">Birth Date :</label><br>
			<input id="bday" type="date" name="bday"><br>
			
			<button type="submit">Register</button>
		</form>
	</div>
</body>
</html>