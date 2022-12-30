<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	<%
		HttpSession session1 = request.getSession();
		session.removeAttribute("adname");
		response.sendRedirect("index.jsp");
	%>
</body>
</html>