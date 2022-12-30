<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome user</title>
<link rel="stylesheet" type="text/CSS" href="user.css">
</head>
<body>
	<%@ include file="nav.jsp"%>
	
	<div class="form-entry">
		<form action="vote" method="post">
		Enter Your voter Card Number
			<input id="voterno" type="number" name="voterno">
			<br>
			<label for="party">Choose Your Party</label>
			<select name="party" id="party">
				<option value="AAP">AAP</option>
				<option value="BJP">BJP</option>
				<option value="Congress">Congress</option>
				<option value="CPI">CPI</option>
			</select>
			<br>
			<button type="submit">Vote</button>
		</form>
		
	</div>
</body>
</html>