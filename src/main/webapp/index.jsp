<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Voting System</title>
<link rel="stylesheet" type="text/CSS" href="style.css">
</head>
<body>

	<%@ include file="nav.jsp"%>
	
	<div class="form-container">
		<form action="voterLogin" method="post">
		<h2>Enter Your Voter ID</h2>
		<label for="voterid">Voter Number</label>
		<br>
		<input id="voterid" type="text" name="ID">
		<br>
		<button type ="submit">login</button>
		<br>
		<a href="admin.jsp">Admin</a>
		</form>
	</div>
	
</body>
</html>