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
 List<String> dates = (List<String>)request.getAttribute("dates");
 %>
 <ul style="list-style:none;">
 <%
 	int i = 0;
	for(Ad ad: reservations){
		%>
		<li style="border: groove;">
		<%=ad.id%>,<%=ad.name%>,<%=ad.city %>,<%=ad.address %>,<%=ad.country %>, <%=ad.price %>,<%=dates.get(i) %>,<%=dates.get(i+1)%>
		</li>
		<%
		i += 2;
	}
 %>
</ul>
<input type="submit" class="buttonNW" value="Back to search" onclick="show_search()">
</body>
</html>