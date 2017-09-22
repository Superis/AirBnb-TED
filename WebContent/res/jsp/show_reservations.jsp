<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="javaClasses.Ad" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
 <% 
 List<Ad> reservations = (List<Ad>)request.getAttribute("reservations");
 %>
 <ul>
 <%
	for(Ad ad: reservations){
		%>
		<li style="border: groove;">
		<input type="submit" value="Διαγραφή">
		<%=ad.id%>,<%=ad.name%>,<%=ad.city %>,<%=ad.address %>,<%=ad.country %>, <%=ad.price %>
		</li>
		<%
	}
 %>
</ul>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
</body>
</html>