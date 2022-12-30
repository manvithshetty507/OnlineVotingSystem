<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import="java.sql.ResultSet"%>
    <%@ page import="java.sql.Statement"%>
    <%@ page import="java.sql.Connection"%>
    <%@ page import="java.sql.PreparedStatement"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>results</title>
<link rel="stylesheet" type="text/CSS" href="result.css">
	<%
		String a[] = new String[100];
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineVotingDB","root","Manvith@507");
	
		PreparedStatement st = Con.prepareStatement("select party,count(party) as c from vote group by party");
		ResultSet rs = ((java.sql.Statement)st).executeQuery("select party,count(party) as c from vote group by party");
		
		int i=1;
		while(rs.next())
		{
			a[i] = rs.getString("c");
			i++;
		}
	%>
</head>
<body>
	<%@ include file="adminnav.jsp"%>
	
	<div class="table-result">
	<table>
		<tr>
			<th>Parties</th>
			<th>Names</th>
			<th>Votes</th>
		</tr>
		
		<tr>
			<td><img src="Aap.jpg" alt="Aap"></td>
			<td>AAP</td>
			<td><%=a[1]==null?0:a[1] %></td>
		</tr>
		
		<tr>
			<td><img src="bjp.jpg" alt="Bjp"></td>
			<td>BJP</td>
			<td><%=a[2]==null?0:a[2] %></td>
		</tr>
		
		<tr>
			<td><img src="congress.png" alt="Congress"></td>
			<td>CONGRESS</td>
			<td><%=a[3]==null?0:a[3]  %></td>
		</tr>
		
		<tr>
			<td><img src="CPI-banner.jpeg" alt="cpi"></td>
			<td>CPI</td>
			<td><%=a[4]==null?0:a[4]  %></td>
		</tr>
	</table>
		
	</div>
</body>
</html>